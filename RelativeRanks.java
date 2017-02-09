//506. Relative Ranks

public class RelativeRanks {
    
    
    class Person {
        int score;
        int pos;
        
        Person(int pos, int score) {
            this.score=score;
            this.pos=pos;
        }
    }
    
    public String[] findRelativeRanks(int[] nums) {
        
        Person[] people = new Person[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            people[i] = new Person(i, nums[i]);
        }
        
        Arrays.sort(people, (p1, p2)->(p2.score-p1.score));
        
        String[] result=new String[nums.length];
        
        for(int i=0; i< people.length; i++) {
            
            if(i == 0) {
                result[people[i].pos] = "Gold Medal" ;
            }
            else if(i == 1) {
                result[people[i].pos] = "Silver Medal" ;
            }
            else if(i == 2) {
                result[people[i].pos] = "Bronze Medal" ;
            }
            else {
                result[people[i].pos] = String.valueOf(i+1) ;
            }
        }
        return result;
    }
}
