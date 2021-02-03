package groovyActivities

class Activity5
{
	static void main(args)
	{
		def list = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		
		def strlist= list.minus([11, 2, 19, 5])
		println "The string list is: "+strlist
		
		def intlist= list.minus(["Mango","Apple","Watermelon"])
		println "The integer list is: "+intlist		
	}
}
