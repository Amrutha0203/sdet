package javaActivity1;

import java.util.Arrays;

public class Activity1_4 {

	public static void main(String[] args) 
	{
		int[] numbers = {2, 8, 9, 10, 1, 7, 3, 4, 6, 12};
		System.out.println("Actual array random number list: "+Arrays.toString(numbers));
		ascendingOrder(numbers);
		System.out.println("Ascending order list: "+Arrays.toString(numbers));

	}
	public static void ascendingOrder(int randomnumbers[])
	{
		int size = randomnumbers.length;
		for (int i=1; i<size; i++)
		{
			int key = randomnumbers[i];
			int j = i-1;
			while(j>= 0 && key<randomnumbers[j])
			{
				randomnumbers[j+1] = randomnumbers[j];
				--j;
			}
			randomnumbers[j+1] = key;
		}
	}
}

