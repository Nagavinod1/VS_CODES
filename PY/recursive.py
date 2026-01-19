list1=['a','b','c','d']
def list(list1,index):
    if(index==len(list1)):
        return
    print(list1[index],end=" ")
    list(list1,index+1)
list(list1,0)