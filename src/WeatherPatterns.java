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
            // Go through and add to list
            for(int j = 0; j < i; j++){
                if(temperatures[j] < temperatures[i]){
                    graph[i].add(temperatures[j]);
                }
            }
        }

        // Go through adjacency list to find the longest run
        for(int i = 0; i < tempSize; i++){
            int len = LongestPathTo(graph, runs, i);
            if(len > maxRun){
                maxRun = len;
            }
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

        // For every temperature connected to me, look to see who has the longest run before me
        for(int i = 0; i < graph[index].size(); i++){
            if(runs[i] > length){
                length = runs[i];
            }
        }
        // Add myself to the last longest run I found
        runs[index] = length + 1;
        return length + 1;
    }
}
