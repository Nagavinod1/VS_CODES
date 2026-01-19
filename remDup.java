public class remDup {
    public static void removeDuplicates(String str,int idx,StringBuilder newStr,boolean Map[]){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar=str.charAt(idx);
        if(Map[currChar-'a']==true){
            removeDuplicates(str, idx+1, newStr, Map);
        }
        else{
            Map[currChar-'a']=true;
            removeDuplicates(str, idx+1, newStr.append(currChar), Map);
        }
    }
    public static void main(String[] args){
        String str="appnnacollege";
        removeDuplicates(str,0,new StringBuilder(""),new boolean[26]);
    }
}
