age =int(input("Enter your age : "))
if(age>=18):
    print("You are eligible to vote")
elif(age>=12 and age<18):
    print("Not eligible to vote as a teenager")
else:
    print("Not eligible as you are child")