package groovyActivities

class Activity6 
{
	static void main(String[] args)
	{
		//Create empty map
		def flowermap= [:]
		
		//Add key-value pairs
		flowermap.put(1, "Sunflower")
		flowermap.put(2, "Rose")
		flowermap.put(3, "Jasmine")
		
		for (def item: flowermap)
		{
			println item
		}
		
		def newFlowerMap= flowermap.plus([4:"Lily", 5:"Marigold"])
		println newFlowerMap
		
		println newFlowerMap.values().sort()
		println newFlowerMap.values().sort {it.length()}
					
	}
	
	
}
