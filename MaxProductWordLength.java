//318. Maximum Product of Word Lengths

public class MaxProductWordLength {
    public int maxProduct(String[] words) {
        
        if(words == null || words.length < 2) {
            return 0;
        }
        
        int[] bitVector = new int[words.length];
        
        for(int i=0; i<words.length; i++) {
            
            for(int j=0; j<words[i].length(); j++) {
                bitVector[i] |= 1<<(words[i].charAt(j) - 'a');
            }
        }
        
        int maxProductLength=0;
        
        for(int i=0; i<words.length; i++) {
            
            for(int j=i+1; j<words.length ;j++) {
                
                if((bitVector[i] & bitVector[j]) == 0 && words[i].length() * words[j].length() > maxProductLength) {
                    maxProductLength =  words[i].length() * words[j].length();
                }
            }
        }
        
        return maxProductLength;
    }
}
