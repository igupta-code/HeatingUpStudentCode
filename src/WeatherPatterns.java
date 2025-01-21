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
    public static int longestWarmingTrend(int[] temperatures) {
        int[] maxRun = new int[temperatures.length];
        maxRun[0] = 0;

        int lastTemp = temperatures[0];
        for(int i = 1; i < temperatures.length; i++){
            // If the temp increases, add to the run number
            if(lastTemp > maxRun[i]) {
                maxRun[i] += lastTemp;
            }
            // If the temp decreases, go back and
            if(lastTemp < maxRun[i]){
                for(int j = 1; j < temperatures.length; j++){
                    if(temperatures[j] < temperatures[i] && ){

                    }
                }
            }
        }

        return 0;
    }
}
