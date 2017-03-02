//496. Next Greater Element I


public class NextGreaterElement {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        
        if(findNums == null || nums == null || findNums.length == 0 || nums.length == 0) {
            return new int[0];
        }
        
        //key: number, value: next greater number
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        //Hash the findNums array with default greater element as -1
        for(int i : findNums) {
            map.put(i, -1);
        }
        
        for(int i : nums) {
                
            while(!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            
            if(map.containsKey(i)) {
                stack.push(i);
            }
        }
        
        int[] result=new int[findNums.length];
        
        for(int i=0; i<findNums.length; i++) {
            
            result[i] = map.get(findNums[i]);
            
        }
        
        return result;
        
    }
}
