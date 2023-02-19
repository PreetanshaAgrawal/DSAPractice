a =input("Enter any number between 5 and 9: ")
try:
    if(int(a) < 5 or int(a) > 9):
        raise ValueError("Number should be in between 5 and 9")
    else:
        print("You have entered ", int(a))    

except:
    if(a == "quit"):
        print("okay goodbye")
    else:
        raise ValueError("invalid entry")     
