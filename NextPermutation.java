//31. Next Permutation

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        
        if(nums == null || nums.length ==0) {
            return;
        }
      
        //find the index of the num which is less than the next element
        int index=0, n=nums.length;
        
        for(int i=n-1; i>0; i--) {
            
            if(nums[i-1] < nums[i]) {
                index=i;
                break;
            }
        }
        //if nums are in descending order
        if(index==0) {
            reverseSort(nums, 0, n-1);
        }
        else {
            //find replacement index and replace it
            //after replacing, reverse sort from index+1, n-1
            int i=n-1;
            for(; i>=index; i--) {
                if(nums[index-1] < nums[i]) {
                    break;
                }
            }
            int temp=nums[i];
            nums[i]=nums[index-1];
            nums[index-1]=temp;
            reverseSort(nums, index, n-1);
        }
       
    }
    
    void reverseSort(int[] nums, int start, int end) {
        
        for(int i=start; i<=(start+end)/2; i++) {
            int temp=nums[start+end-i];
            nums[start+end-i]=nums[i];
            nums[i]=temp;
        }
    }
} 
