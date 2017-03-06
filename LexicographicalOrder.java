//386. Lexicographical Numbers

public class LexicographicalOrder {
    public List<Integer> lexicalOrder(int n) {
        
        int curr=1;
        List<Integer> list=new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            
            list.add(curr);
            
            if(curr * 10 <= n) {
                curr *= 10;
            }
            else if(curr%10 != 9 && curr+1 <=n) {
                curr++;
            }
            else {
                curr /= 10;
                while(curr%10 == 9) {
                    curr /= 10;
                }
                curr++;
            }
        }
        return list;
    }
}
