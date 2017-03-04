//207. Course Schedule

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
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
                
                if(isCyclicDFS(i, adjacencyList, visited, set)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean isCyclicDFS(int mainCourse, LinkedList<Integer>[] list, boolean[] visited, Set<Integer> set) {
        
        
        if(visited[mainCourse]) {
            return false;
        }
        
        visited[mainCourse]=true;
        
        set.add(mainCourse);
        
        for(int i : list[mainCourse]) {
            
            if(!visited[i] && isCyclicDFS(i, list, visited, set)) {
                return true;
            }
            else {
                 if(set.contains(i)) {
                     return true;
                 }
            }
        }
        
        set.remove(mainCourse);
        return false;
        
    }

}
