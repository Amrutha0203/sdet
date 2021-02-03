#Fruit Shop
fruit_shop = {
                "apple" : 100,
                "mango" : 80,
                "grapes" : 90,
                "banana" : 50,
                "orange" : 110
}
available_fruit= input("Enter the fruit name you need: ").lower()

if (available_fruit in fruit_shop) :
                    print(available_fruit,"is available")
else:
                    print(available_fruit, "is not available")