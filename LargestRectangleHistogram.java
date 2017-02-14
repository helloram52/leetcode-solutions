//84. Largest Rectangle in Histogram

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        
        for(int i=0; i<=heights.length; i++) {
            
            int height=(i==heights.length)?0:heights[i];
            
            if(stack.isEmpty() || height >= heights[stack.peek()] ) {
                stack.push(i);
            }
            else {
                int tp=stack.pop();
                maxArea=Math.max(maxArea, heights[tp] * (stack.isEmpty()?i:(i-1-stack.peek())));
                i--;
            }
        }
        
        return maxArea;
    }
}
