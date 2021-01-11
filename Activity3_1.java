package javaActivity3;

import java.util.ArrayList;

public class Activity3_1
{
	public static void main(String[] args) 
	{
		ArrayList<String> myList= new ArrayList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("D");
		myList.add("E");
		
		for(String s: myList)
		{
			System.out.println("The list of the names: "+s);			
		}
		
		System.out.println("The third element in the list is: " + myList.get(2));
		System.out.println("Is Z present in the list: " + myList.contains("Z"));
        System.out.println("The size of ArrayList: " + myList.size());
        myList.remove("D");
        System.out.println("The new size of ArrayList: " + myList.size());
        System.out.println("The new Arraylist is: "+myList);		
	}

}
