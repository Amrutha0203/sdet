#Fibonacci Numbers - Solution
def fibonacci(number):
            if number <= 1:
                            return number
            else:
                            return(fibonacci(number-1) + fibonacci(number-2))

Num= int(input("Enter a number: "))

if Num <= 0:
                print("Enter a positive number")
else:
                print("fibonacci sequence is:")
                for i in range(Num):
                                        print(fibonacci(i))
