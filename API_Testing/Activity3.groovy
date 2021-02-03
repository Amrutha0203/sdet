package groovyActivities

class Activity3 
{
	static void main(String[] args)
	{
		def a=0, b=1, count=10
		 println a
		 count.times { 
			 (a, b)= [b, a+b]
			 println "\n" +a			 
		 }
	}
}
