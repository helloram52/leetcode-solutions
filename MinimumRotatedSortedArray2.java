
//154. Find Minimum in Rotated Sorted Array II

public class MinimumRotatedSortedArray2 {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int start=0, end=nums.length-1;
        
        while(start < end) {
            
            int mid=(start+end)/2;
            
            if(nums[mid] < nums[end]) {
                end=mid;
            }
            else if(nums[mid] > nums[end]) {
                start=mid+1;
            }
            else {
                end--;
            }
            
        }
    
        return nums[start];
    }
}
