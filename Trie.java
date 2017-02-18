//208. Implement Trie (Prefix Tree)

class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> map;
	boolean endOfWord;

	TrieNode() {
		map=new HashMap<>();
		endOfWord=false;
	}
}

public class Trie {
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String str) {
        
        if( str.length() == 0 ) {
			return;
		}

		TrieNode currNode=root;

		for (int i=0; i<str.length() ; i++ ) {
			
			char currChar = str.charAt(i);

			if( !currNode.map.containsKey(currChar) ) {

				TrieNode newNode = new TrieNode();
				currNode.map.put(currChar, newNode);
			}

			currNode=currNode.map.get(currChar);
		}

		currNode.endOfWord=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String str) {
        
        if( str.length() == 0 ) {
			return false;
		}	

		TrieNode currNode=root;	

		for (int i=0; i<str.length() ; i++ ) {
			
			char currChar = str.charAt(i);

			if( !currNode.map.containsKey(currChar) ) {

				return false;
			}

			currNode=currNode.map.get(currChar);

		}

		return currNode.endOfWord;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String str) {
            
        if( str.length() == 0 ) {
			return false;
		}	

		TrieNode currNode=root;	

		for (int i=0; i<str.length() ; i++ ) {
			
			char currChar = str.charAt(i);

			if( !currNode.map.containsKey(currChar) ) {

				return false;
			}

			currNode=currNode.map.get(currChar);

		}

		return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
