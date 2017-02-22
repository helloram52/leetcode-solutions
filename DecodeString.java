//394. Decode String

public class DecodeString {
    public String decodeString(String s) {
        
        if(s == null || s.length() == 0) {
            return "";
        }
        
        Stack<String> result=new Stack<>();
        Stack<Integer> count=new Stack<>();
        int i=0;
        result.push("");
        
        while(i < s.length()) {
            
            char currChar = s.charAt(i);
            //if number
            if(currChar >= '0' && currChar <= '9') {
                int numStart=i;
                while(s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(numStart,i+1)));
            }
            else if(currChar == '[') {
                result.push("");
            }
            else if(currChar == ']') {
                int times=count.pop();
                StringBuilder sb=new StringBuilder();
                String currString=result.pop();
                
                for(int j=0; j<times; j++) {
                    sb.append(currString);
                }
                result.push(result.pop()+sb.toString());
            }
            else {
                result.push(result.pop()+currChar);
            }
            i++;
        }
        
        return result.pop();
    }
}
