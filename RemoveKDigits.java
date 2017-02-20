//402. Remove K Digits

public class RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        
        if(k>=num.length()) {
            return "0";
        }
        
        int remaining=num.length()-k;
        char[] stack=new char[num.length()];
        int top=0;
        
        for(int i=0; i<num.length(); i++) {
            
            char currChar=num.charAt(i);
            while(k>0 && top>0 && stack[top-1] > currChar) {
                top--;
                k--;
            }
            stack[top++]=currChar;
        }
        
        int start=0;
        
        while(start<(num.length()-k) && stack[start] == '0') start++;
        
        return start == remaining? "0": new String(stack, start, remaining - start);
    }
}
