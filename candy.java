//  TC: O(N) for traversing array
// SC: O(N) for storing candies values for all children

import java.util.Arrays;

public class candy {

	public int candyFre(int[] ratings) {
		
		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		// we know that we need to fill the array with atleast one candy, SO we need to update our array with value 1
		
		// We will start our array from first index, since we need to compare our previous value with current value,
		// if the current rating is greater than previous rating, we update our currenr candy to that child with one more than previous child
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i] < ratings[i-1])
				candies[i] = candies[i-1]+1;
		}
		
		// to calculate the sum, we will store the last value into sum variable since while checking for array with descending array
		// our previous loop will onyl check for ascending array values and update our candies array,
		// to check for array which is in descending values, we need to check from last and update our candies for children with high ratings at start
		
		int sum = candies[candies.length-1];
		// we start from last but one index since we need to compare it next previous index, if the previous index is greater  rating, we update the childs candies
		// we also need to check that we dont update the child with min rating as well, so we will compare the max value of previous candy with current candy value and store the max
		for(int i=ratings.length-2;i>=0;i--) {
			if(ratings[i] > ratings[i+1]) {
				candies[i] = Math.max(candies[i+1]+1, candies[i]);
			}
			// calculate the sum for every child
			sum += candies[i];
		}
		// return the sum stored
		return sum;
	}
	
	public static void main(String[] args) {
		
	}
}
