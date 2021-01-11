package javaActivity3;

import java.util.HashSet;

public class Activity3_2
{

	public static void main(String[] args) 
	{
		HashSet<String> hs= new HashSet<String>();
		hs.add("Book");
		hs.add("Pen");
		hs.add("Pencil");
		hs.add("Crayons");
		hs.add("Paint");
		hs.add("Paper");

		System.out.println("The size of the hashset is: "+hs.size());
		System.out.println("Actual hashset objects: "+hs);
		hs.remove("Pencil");

		if(hs.remove("Eraser"))
		{
			System.out.println("Eraser removed from the Set");
		} 
		else 
		{
			System.out.println("Eraser is not present in the Set");
		}

		System.out.println("Sharpner is present in the hashet or not: " + hs.contains("Sharpner"));
		System.out.println("Paint is present in the hashset or not: " + hs.contains("Paint"));
		System.out.println("The updated hashset is: "+hs);		
	}
}
