import java.util.*;
public class taskScheduler {
// we will sort the frequencies of every character in the array and find the maximum idle_time that is possible for the tasks given
	public int leastInterval(char[] tasks, int n) {
		
		int[] frequencies = new int[26];
		
		for(int t: tasks) {
			frequencies[t-'A']++;
		}
		
		Arrays.sort(frequencies);
		
		// find the maximum frequency from the array
		int fMax = frequencies[25];
		
		// calculate the idle time since we know that the idle_time is the max frequency * n
		int idle_time = (fMax - 1) *n;
		
		// we will start the index from last but one array, and keep checking if the idle_time is greater than 0 because we dont not want
		// go for negative values of idle time which might result in wrong tasks length
		for(int i = frequencies.length-2;i>=0 && idle_time > 0;i--) {
			
			// subtract the idletime from the min frequency values because we know that we can use that character and reduce our idle time because 
			// we can excute some other tasks in the array given instead of keeping repeating consecutive tasks idle
			idle_time -= Math.min(fMax-1, frequencies[i]);
		}
		// if any case, our frequency values are large and our idle time goes to negative. we update it to 0 since we know that 
		// we cannot have negative idle time for any tasks		
		idle_time = Math.max(0,  idle_time);
		// return sum of  length of tasks and idle time 
		return idle_time+tasks.length;
		
	}
}
