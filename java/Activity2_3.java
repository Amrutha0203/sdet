package javaActivity2;

interface BicycleParts
{
	public int gears= 0;
	public int speed= 0;
}
interface BicycleOperations
{
	public void applyBrake(int decrement);
	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations
{
	public int gears;
	public int speed;

	public Bicycle(int gears, int speed)
	{
		this.gears= gears;
		this.speed= speed;
	}
	public void applyBrake(int decrement)
	{
		speed -= decrement;
		System.out.println("The speed of the bicycle is: "+speed);
	}
	public void speedUp(int increment)
	{
		speed += increment;
		System.out.println("The speed of the bicycle is: "+speed);
	}
	public String bicycleDesc()
	{
        return("No of gears in bicycle are "+gears+ "\n Speed of bicycle is: " +speed);
    }
}
class MountainBike extends Bicycle
{
    public int seatHeight;
    public MountainBike(int gears, int currentSpeed, int startHeight)
    {
        super(gears, currentSpeed);
        seatHeight= startHeight;
    }
    public void setHeight(int newValue)
    {
        seatHeight= newValue;
    }
    public String bicycleDesc()
    {
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }  
}
    
public class Activity2_3 
{
	public static void main(String[] args) 
	{
		MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
	}
}
