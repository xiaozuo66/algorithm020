public class Solution {

    public int dubbleBfs() {

        Set<String> beginVisited=new HashSet();

        Set<String> endVisited=new HashSet();

        while(!beginVisited.isEmpty() && !endVisited.isEmpty()){
            if(beginVisited.size()>endVisited.size()){
                Set<String> temp=beginVisited;
                beginVisited=endVisited;
                endVisited=temp;
            }
            Set<String> nextLevel=new HashSet();
            bfs(nextLevel);
            beginVisited=nextLevel;
        }
        return 0;
    }

    private boolean bfs(Set<String> set){
        return false;
    }
}