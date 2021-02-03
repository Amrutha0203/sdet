package groovyActivities

class Activity1
{
	static void main(args)
	{
		def x
		int y
		def array = [3, 2.6, "Training", true, x, y]
		array.each { println "Each variable in array is: " +it}
		array.each {println "Data type of each variable in array is: " +it.getClass()}
	}
}
