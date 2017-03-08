//532. K-diff Pairs in an Array


public class kDiffPairs {
    public int findPairs(int[] nums, int k) {
        
        if(nums == null || nums.length <= 1 || k < 0) {
            return 0;
        }
        
        StringBuilder stringPair = new StringBuilder();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        int left=0, right=1, count=0;
        
        while( right < nums.length && left <= right) {
            
            if(left == right) {
                right++;
                continue;
            }
            
            int difference =nums[right]-nums[left];
            
            if( difference == k) {
                
                String pair=stringPair.append(nums[left]).append(",").append(nums[right]).toString();
                
                if(!set.contains(pair)) {
                    count++;
                    set.add(pair);
                }
                stringPair=new StringBuilder();
                left++;
            }
            else if(difference < k) {
                right++;
            }
            else {
                left++;
            }

        }
        
        return count;
    }
}
