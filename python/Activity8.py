#List Checker
listnum = list(input("Enter a list of numbers: ").split(','))
print(listnum)
firstnum = listnum[0]
lastnum = listnum[-1]

if(firstnum==lastnum):
            print(True)
else:
           print(False)
