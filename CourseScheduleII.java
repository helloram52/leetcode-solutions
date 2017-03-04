//210. Course Schedule II


public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        
        Stack<Integer> stack=new Stack<>();
        
        if(!canFinish(numCourses, prerequisites, stack)) {
            return new int[0];
        }
        
        int[] result=new int[numCourses];
        int i=numCourses-1;
        
        if(!stack.isEmpty()) {
            while(!stack.isEmpty()) {
                result[i--]=stack.pop();
            }
        }
        else {
            for( i=0; i<numCourses; i++) {
                result[i]=i;
            }
        }
        
        return result;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites, Stack<Integer> stack) {
        
        if(numCourses <= 0 || prerequisites.length == 0) {
            return true;
        }
        
        LinkedList<Integer>[] adjacencyList = new LinkedList[numCourses];
        
        for(int i=0; i<numCourses; i++) { 
            adjacencyList[i]=new LinkedList<>();
        }
        
        for(int i=0; i<prerequisites.length; i++) {
            
            adjacencyList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<numCourses; i++) {
            
            if(!visited[i]) {
                
                if(isCyclicDFS(i, adjacencyList, visited, set, stack)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean isCyclicDFS(int mainCourse, LinkedList<Integer>[] list, boolean[] visited, Set<Integer> set, Stack<Integer> stack) {
        
        
        if(visited[mainCourse]) {
            return false;
        }
        
        visited[mainCourse]=true;
        
        set.add(mainCourse);
        
        for(int i : list[mainCourse]) {
            
            if(!visited[i] && isCyclicDFS(i, list, visited, set, stack)) {
                return true;
            }
            else {
                 if(set.contains(i)) {
                     return true;
                 }
            }
        }
        stack.push(mainCourse);
        set.remove(mainCourse);
        return false;
    }
    
}

