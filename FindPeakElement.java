//162. Find Peak Element

public class PeakElement {
    public int findPeakElement(int[] nums) {
        
        int start=0, end=nums.length, mid=0;
        
        while(start < end) {
            
            mid=(start+end)/2;
            
            if( mid > 0 && mid+1 < nums.length && nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            }
            else if( mid > 0 && mid < nums.length && nums[mid-1] < nums[mid] ) {
                start=mid+1;
            }
            else {
                end=mid;
            }
        }
        
        return mid;
    }
}
