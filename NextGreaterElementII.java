//503. Next Greater Element II

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result=new int[nums.length];
        Arrays.fill(result, -1);
        
        //store the indices rather than values for ease of writing the output
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums.length*2; i++) {
            
            int num=nums[i%nums.length];
            
            while(!stack.isEmpty() && nums[stack.peek()] < num) {
                
                result[stack.pop()]=num;
            }
            
            if(i<nums.length) {
                stack.push(i);
            }
        }
        
        return result;
        
    }
}
