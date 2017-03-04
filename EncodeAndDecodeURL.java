//535. Encode and Decode TinyURL

public class EncodeAndDecodeURL {
    
    Map<String, String> urlMap= new HashMap<>();
    List<Character> charList = new ArrayList<>();
    int IDENTIFIER_SIZE =6;
    
    Codec() {
        
        
        
        for(char i='0'; i<='9';i++) {
            charList.add(i);
        }
        
        for(char i='a'; i<='z';i++) {
            charList.add(i);
        }
        
        for(char i='A'; i<='Z';i++) {
            charList.add(i);
        }
    }
    
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        Random randomObj = new Random();
        
        String urlPrefix= "http://tinyurl.com/";
        
        StringBuilder tinyUrl=new StringBuilder();
        
        boolean uniqueURLNotFound=true;
        
        while(uniqueURLNotFound) {
        
            for(int i=0; i<IDENTIFIER_SIZE;i++) {
                
                int index=randomObj.nextInt(charList.size());
                
                tinyUrl.append(charList.get(index));
            }
        
            uniqueURLNotFound=urlMap.containsKey(tinyUrl.toString());
        }
        
        urlMap.put(tinyUrl.toString(), longUrl);
        
        return tinyUrl.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
        return urlMap.get(shortUrl);
    }
}
