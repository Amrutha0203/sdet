#List Sum Calculator
numbers = list(input("Enter a lsit of numbers with comma seperated: ").split(','))
total=0
for i in numbers:
            total +=int(i)
print(total)