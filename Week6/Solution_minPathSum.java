class Solution {
    public int minPathSum(int[][] grid) {

        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;

        int minSum=0;

        int result[][]=new int[m+1][n+1];//默认值都是0

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    result[i+1][j+1]=result[i][j+1]+result[i+1][j]+grid[i][j];
                }else {
                    result[i + 1][j + 1] = Math.min(result[i][j + 1], result[i + 1][j]) + grid[i][j];
                }
            }
        }
        return result[m][n];
    }
}

// 0 0 0 0
// 0 1 3 1
// 0 1 5 1
// 0 4 2 1