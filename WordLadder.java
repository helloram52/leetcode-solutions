//127. Word Ladder

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> beginSet=new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> wordDict=new HashSet<>(wordList);
        
        if(!wordDict.contains(endWord)) {
            return 0;
        }
        
        int len=1;
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            
            if(beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet=endSet;
                endSet=temp;
            }
            
            Set<String> toAdd = new HashSet<>();
            
            for(String word: beginSet) {
                
                char[] chars=word.toCharArray();
                
                for(int i=0; i<chars.length; i++) {
                    
                    for(char ch='a'; ch<='z'; ch++) {
                        char old=chars[i];
                        chars[i]=ch;
                        
                        String currWord = new String(chars);
                        
                        if(endSet.contains(currWord)) {
                            return len+1;
                        }
                        
                        if(wordDict.contains(currWord)) {
                            toAdd.add(currWord);
                            wordDict.remove(currWord);
                        }
                        chars[i]=old;
                    }
                }
            }
            len++;
            if(toAdd.size() == 0) {
                return 0;
            }
            beginSet=toAdd;
        }
        
        return 0;
    }
}
