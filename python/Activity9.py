#Combining Lists
listnum1= [2,8,9,6,3,13]
print(listnum1)
listnum2= [10,14,17,18,20,19]
print(listnum2)

listnum3=[]

for x in listnum1:
            if(x % 2 !=0):
                    listnum3.append(x)

for y in listnum2:
            if(y % 2==0):
                        listnum3.append(y)

print("The new list formed by adding odd numbers from list1 and even numbers from list2", listnum3)