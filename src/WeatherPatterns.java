// Jan 23, 2025
import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Isha Gupta
 */

public class WeatherPatterns {
    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */

    public static int longestWarmingTrend(int[] temperatures){
        int tempSize = temperatures.length;
        ArrayList<Integer>[] graph = new ArrayList[tempSize];
        int[] runs = new int[tempSize];
        int maxRun = 0;

        // Set up the adjacency structure
        for(int i = 0; i < tempSize; i++){
            graph[i] = new ArrayList<Integer>();
            // Go through and add to list and add everyone that connects to you
            for(int j = 0; j < i; j++){
                if(temperatures[j] < temperatures[i]){
                    graph[i].add(j);
                }
            }
        }

        // Go through adjacency list to find the longest run
        for(int i = 0; i < tempSize; i++){
            maxRun = Math.max(maxRun, LongestPathTo(graph, runs, i));
        }
        return maxRun;
    }

    public static int LongestPathTo(ArrayList<Integer>[] graph, int[] runs, int index){
        int length = 0;
        // Base case: if I don't have any connections, return 1
        if(graph[index].isEmpty()){
            runs[index] = 1;
            return 1;
        }
        // Base case: if I've already been here and know the longest run, return the value I've already found
        if(runs[index] != 0){
            return runs[index];
        }

        // For every temperature connected to me, look to see who has the longest run before me
        for(int day: graph[index]){
            length = Math.max(length, LongestPathTo(graph, runs, day));
        }

        // Add myself to the last longest run I found
        runs[index] = length + 1;
        return length + 1;
    }
}
