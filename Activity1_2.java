package javaActivity1;

import java.util.Arrays;

public class Activity1_2
{
	public static void main(String[] args) 
	{
		int[] numberlist= {10, 77, 10, 54, -11, 10};
		System.out.println("Actual Arraylist: " + Arrays.toString(numberlist));

		int findnum = 10;
		int sumnum = 30;
		
		System.out.println("The sum of 10's in array is 30: "+result(numberlist, findnum, sumnum));
	} 
	public static boolean result(int[] numberlist, int findnum, int sumnum)
	{
		int total= 0;

		for (int number: numberlist)
		{
			if(number==findnum)
			{
				total += findnum;

			}
			if (total > sumnum)
			{
				break;
			}
		}
		return total == sumnum;
	}

}
