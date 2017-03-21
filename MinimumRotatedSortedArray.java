
//153. Find Minimum in Rotated Sorted Array

public class MinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int start=0, end=nums.length, first=nums[0];
        
        while(start < end) {
            
            int mid=(start+end)/2;
            
            if(nums[mid] >= first) {
                start=mid+1;
            }
            else {
                end=mid;
            }
        }
        
        return (start>=nums.length)?nums[0]:nums[start];
    }
}
