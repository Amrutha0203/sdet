package javaActivity3;

import java.util.LinkedList;
import java.util.Queue;

public class Activity3_3A
{
	public static void main(String[] args)
	{
		Queue<Integer> q= new LinkedList<>();
		
		for(int i=0; i<5; i++)
		{
			q.add(i);
		}
		
		System.out.println("The elements in the queue is: "+q);
		int removeElement = q.remove();
		System.out.println("The removed element in the queue is: "+removeElement);
		int firstElement= q.peek();
		System.out.println("The first element in the queue is: "+firstElement);
		System.out.println("The size of the queue is: "+q.size());
	}
}
