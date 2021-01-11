package javaActivity3;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Activity3_3B {

	public static void main(String[] args) 
	{
		Deque<String> dq = new LinkedList<String>();
		dq.add("Cat");
		dq.add("Dog");
		dq.add("Cow");
		dq.add("Lion");
		dq.add("Tiger");
		dq.add("Horse");

		Iterator<String> iterator = dq.iterator();
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("The first element in the queue is: "+dq.peekFirst());
		System.out.println("The last element in the queue is: "+dq.peekLast());
		
		System.out.println("Dose Wolf presnt in the queue: "+dq.contains("Wolf"));
		dq.removeFirst();
		dq.removeLast();
		System.out.println("The elements in the queue after removal: "+dq);
		System.out.println("The size of the queue after removal: "+dq.size());

	}

}
