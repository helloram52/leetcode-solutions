//42. Trapping Rain Water
public class TrappingRainWater {
    
    public int trap(int[] A) {
            
        if( A == null || A.length == 0 ) {
	        return 0;
	    }
	    
	    int total = 0, maxLeft = 0, maxRight = 0, left = 0, right = A.length - 1;
	    
	    while( left <= right ) {
	     if( A[left] <= A[right] ) {
            if( maxLeft <= A[left] )
	            maxLeft = A[left];
            else
                total += maxLeft - A[left];
            left++;
	     }
	     else {
	         if( A[right] < A[left] ) {
                if( maxRight <= A[right] )
	                maxRight = A[right];
                else 
                    total += maxRight - A[right];
	            right--;
	         }
	     }
	    }
	    return total;       
    }
}
