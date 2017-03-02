//33. Search in Rotated Sorted Array

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = nums[0], start=1, end=nums.length;
        //find the pivot element
        while(start < end) {
            
            int mid=(start+end)/2;
            
            if(nums[mid] > left) {
                start=mid+1;
            }
            else {
                end=mid;
            }
            
        }
        
        int pivot=start;
        
        start=0;
        end=nums.length;
        
        while(start < end) {
            
            int mid=(start+end)/2;
            int originalMid= (mid+pivot)%nums.length;
            
            if(nums[originalMid] == target) {
                return originalMid;
            }
            else if(nums[originalMid] > target) {
                end=mid;
            }
            else {
                start=mid+1;
            }
        }
        
        return -1;
    }
}
