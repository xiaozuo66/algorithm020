class Solution {

    private List<String> result=new ArrayList();

    private int[][]direct=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    private int m;
    private int n;

    private Set<String> set=new HashSet();

    private boolean[][] marked;

    private char[][] board;

    private int max=0;

    public List<String> findWords(char[][] board, String[] words) {

        if(board==null || words==null){
            return result;
        }
        this.m=board.length;
        this.n=board[0].length;

        this.board=board;

        marked=new boolean[m][n];
        
        for(String word:words){
            max=Math.max(word.length(),max);
            set.add(word);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(i,j,"");
            }
        }
        return result;
    }

    private void dfs(int i,int j,String content){
        if(content.length()==max){
            return;
        }
        content=content+board[i][j];
        marked[i][j]=true;
        if(set.contains(content) && !result.contains(content)){
            result.add(content);
            if(result.size()==set.size()){
                return;
            }
        }
        for(int s=0;s<4;s++){
            int ii=i+direct[s][0];
            int jj=j+direct[s][1];
            if(check(ii,jj) && !marked[ii][jj]){
                dfs(ii,jj,content);
            }
        }
        marked[i][j]=false;
        return;
    }

    private boolean check(int i,int j){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
}