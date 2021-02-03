package groovyActivities

class Activity2 
{
	static void main(args)
	{
		def marks = [38, 45, 75, 57, 98]
		def sum = 0
		def avg = 0
		def grade= "F"
		
		marks.each { sum+=it }
		avg= sum/marks.size() as Integer
		
		switch(avg)
		{
			case 90..100:
					grade="A"
			        break
			case 80..89:
					grade="B"
					break
			case 70..79:
					grade="C"
					break
			case 50..69:
					grade="D"
					break
			case 0..49:
					grade="F"
					break
			default:
					println "invalid value"
		}
		 
		println "The highest marks is: " +marks.max()
		println "The Lowest marks is: "  + marks.min()
		println "The average marks is: " +avg
		println "The avergae mark grade is: " +grade	
	}
}
