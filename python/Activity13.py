#Adding List Numbers
def sum_of_num(numbers):
            sum=0
            for num in numbers:
                    sum += int(num)
            return sum
            
numberlist= list(input("Enter the list of numbers: ").split(','))
result = sum_of_num(numberlist)
print("The sum of numbers entered is: "+str(result))
