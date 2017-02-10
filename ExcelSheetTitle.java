//168. Excel Sheet Column Title

public class ExcelSheetTitle {
    public String convertToTitle(int n) {
        
        if(n<=0) {
            return "";
        }
        
        StringBuilder result=new StringBuilder();
        char[] letters=new char[26];
        int j=0;
        
        for(char i='A'; i<='Z'; i++) {
            letters[j++]=i;
        }
        
        int quotient=n, remainder=0;
        
        while(quotient > 26) {
            
            remainder = quotient % 26;
            
            if(remainder == 0 && quotient > 1) {
                remainder=26;
                quotient--;
                result.append(letters[remainder-1]);
            }
            else if(remainder != 0) {
                result.append(letters[remainder-1]);
            }
            
            quotient /= 26;
        }
        
        result.append(letters[quotient-1]);
        
        return result.reverse().toString();
    }
}
