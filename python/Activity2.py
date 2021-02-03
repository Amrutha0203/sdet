#Odd or Even Numbers
number = int(input("Enter a number: "))
mod = number % 2
if mod > 0:
    print("The number entered is an odd number")
else:
    print("The number entered is an even number")