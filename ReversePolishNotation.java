//150. Evaluate Reverse Polish Notation

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        
        Stack<String> stack=new Stack<>();
        
        for(int i=0; i<tokens.length; i++) {
            
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")) {
                
                int secondOperand=Integer.parseInt(stack.pop());
                int firstOperand=Integer.parseInt(stack.pop());
                
                if(tokens[i].equals("+")) {
                    stack.push((firstOperand+secondOperand)+"");
                }
                else if(tokens[i].equals("-")) {
                    stack.push((firstOperand-secondOperand)+"");
                }
                else if(tokens[i].equals("*")) {
                    stack.push((firstOperand*secondOperand)+"");
                }
                else if(tokens[i].equals("/")) {
                    stack.push((firstOperand/secondOperand)+"");
                }
            }
            else {
                stack.push(tokens[i]);
            }
        }
        
        return Integer.parseInt(stack.pop());
    }
}
