package javaActivity1;

public class Activity1_1 
{	
	public static void main(String[] args)
	{
		Car suzuki = new Car();
		suzuki.make = 2014;
		suzuki.color = "Black";
		suzuki.transmission = "Manual";
		
		suzuki.displayCharacterstics();
		suzuki.accelarate();
		suzuki.brake();
	}

}
