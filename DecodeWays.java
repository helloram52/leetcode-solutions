//91. Decode Ways

public class DecodeWays {
    public int numDecodings(String s) {
     
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        if(s.charAt(0) == '0') {
            return 0;
        }
        
        int[] count=new int[s.length()+1];
        count[0]=1;
        count[1]=1;
        
        for(int i=2; i<=s.length(); i++) {
            
            count[i]=0;

            if(s.charAt(i-1) > '0') {
                count[i]=count[i-1];
            }
            
            if( (s.charAt(i-2) < '2' && s.charAt(i-2) != '0') || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7') ) {
                count[i] += count[i-2];
            }
            
        }
        
        return count[s.length()];
    }
}
