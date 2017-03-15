//87. Scramble String

public class Solution {
    public boolean isScramble(String s1, String s2) {
        
        
        if(s1.equals(s2)) {
            return true;
        }
        
        int[] characters = new int[256];
    
        for(int i=0; i<s1.length(); i++) {
            characters[s1.charAt(i)]++;
            characters[s2.charAt(i)]--;
        }
        
        for(int i=0; i<characters.length; i++) {
            if(characters[i] != 0) {
                return false;
            }
        }
        
        for(int i=1; i<s1.length(); i++) {
            
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) 
                && isScramble(s1.substring(i), s2.substring(i))) {
                    return true;
            }
            if(isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) 
                && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) {
                    return true;
            }
        }
        
        return false;
        
    }
}
