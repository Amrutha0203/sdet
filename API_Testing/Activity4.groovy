package groovyActivities

class Activity4 
{
	static void main(String[] args)
	{
		def str ="This is a Groovy Language"
		
		def revstr= str.reverse()
		println "Reversed String: " +revstr
		
		def substr = str.substring(10)
		println "The substring is: "+substr
		
		def splitstr= str.split(" ")
		println "The splitted words are: "+splitstr
		
		def rmvstr = str.minus("Groovy")
		println "The string after removal: "+rmvstr
		
		def lowerstr = str.toLowerCase()
		println "The lowercase string is: "+lowerstr
		
		def upperstr = str.toUpperCase()
		println "The uppercase string is: "+upperstr
		
		def matchstatus = str.matches("(.*)Groovy(.*)")
		if(matchstatus)
		{
			println "String matches"
		}
		
		def replacestr = str.replaceAll("Groovy", "Java")
		println "The replaced string is: "+replacestr
	}
}
