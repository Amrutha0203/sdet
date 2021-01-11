package javaActivity1;

public class Car 
{
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	Car()
	{
		tyres=4;
		doors=4;
	}
	public void displayCharacterstics()
	{
		System.out.println("The color of the car is: "+color);
		System.out.println("The transmission of the car is: "+transmission);
		System.out.println("The car was made in: "+make);
		System.out.println("The number of tyres in the car is: "+tyres);
		System.out.println("The number of doors in the car is: "+doors);
	}
	public void accelarate()
	{
		System.out.println("Car is moving forward");
	}
	public void brake()
	{
		System.out.println("Car has stooped");
	}
	
}
