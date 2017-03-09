//514. Freedom Trail

public class FreedomTrail {
    
    Map<String, Map<Integer, Integer>> map = new HashMap<>();
    
    public int findRotateSteps(String ring, String key) {
        
        if(key.length() == 0 || ring.length() == 0) {
            return 0;
        }
        
        return findRotateStepsUtil(ring, key, 0);
    }
    
    int findRotateStepsUtil(String ring, String key, int j) {
        
        if(j == key.length()) {
            return 0;
        }
        
        Map<Integer, Integer> result=map.get(ring);
        if(result != null) {
            if(result.containsKey(j)) {
                return result.get(j);
            }
        }
        
        int forward = ring.indexOf(key.charAt(j));
        int backward = ring.lastIndexOf(key.charAt(j));
        
        int clockWiseLength = forward + findRotateStepsUtil(ring.substring(forward)+ring.substring(0, forward), key, j+1);
        int antiClockWiseLength = ring.length()-backward + findRotateStepsUtil(ring.substring(backward)+ring.substring(0, backward), key, j+1);
        
        int steps=1+Math.min(clockWiseLength, antiClockWiseLength);
        
        result = map.getOrDefault(ring, new HashMap<>());
        result.put(j, steps);
        map.put(ring, result);
        
        return steps;
    }
}
