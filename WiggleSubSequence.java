//376. Wiggle Subsequence

public class WiggleSubSequence {
    
    public int wiggleMaxLength(int[] nums) {
        
        if( nums.length == 0) {
            return 0;
        }
        
        int[] length=new int[nums.length];
        int[] prev=new int[nums.length];
        
        Arrays.fill(length, 1);
        
        for(int i=1; i<nums.length; i++) {
            
            for(int j=0; j<i; j++) {
                
                if(nums[i] == nums[j]) {
                    continue;
                }
                
                if(nums[j] < nums[i]) {
                    
                    if(length[j]>1 && prev[j] > nums[j]) {
                        
                        length[i]=Math.max(length[i], length[j]+1);
                        prev[i]=nums[j]; 
                    }
                    else {
                        if( length[i] < 2) {
                            length[i]=2;
                            prev[i] = nums[j];
                        }
                    }
                }
                else {
                    
                    if(length[j]>1 && prev[j] < nums[j]) {
                        
                        length[i]=Math.max(length[i], length[j]+1);
                        prev[i]=nums[j];
                    }
                    else {
                        if( length[i] < 2) {
                            length[i]=2;
                            prev[i] = nums[j];
                        }
                    }
                }
            }
        }
        return length[nums.length-1];
    }
}
