//241. Different Ways to Add Parentheses

public class diffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        
        Map<String, List<Integer>> resultMap = new HashMap<>();
        return diffWaysToCompute(input, resultMap);
    }
     
     public List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> map) {
         
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<input.length(); i++) {
            
            char currChar = input.charAt(i);
            
            if(currChar == '+' || currChar == '-' || currChar == '*') {
                
                List<Integer> part1;
                String subString = input.substring(0, i);
                
                if(map.containsKey(subString)) {
                    part1 = map.get(subString);
                }
                else {
                    part1 = diffWaysToCompute(subString, map);
                }
                
                List<Integer> part2;
                subString = input.substring(i+1);
                
                if(map.containsKey(subString)) {
                    part2 = map.get(subString);
                }
                else {
                    part2 = diffWaysToCompute(subString, map);
                }
                
                
                for(int num1: part1) {
                    
                    for(int num2 : part2) {
                        
                        if(currChar == '+') {
                            result.add(num1 + num2);
                        }
                        else if(currChar == '-') {
                            result.add(num1 - num2);
                        }
                        else {
                            result.add(num1 * num2);
                        }
                    }
                }
            }
        }
        
        if(result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        
        map.put(input, result);
        
        return result;
    }
}
