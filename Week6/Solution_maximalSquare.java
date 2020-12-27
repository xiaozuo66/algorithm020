class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }

        int m=matrix.length;
        int n=matrix[0].length;
        
        int maxSide = 0;

        int result[][]=new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(matrix[i][j]=='1'){
                    //只有为1时才处理
                    result[i+1][j+1]=Math.min(Math.min(result[i + 1][j],result[i][j + 1]),result[i][j])+1;
                    maxSide=Math.max(maxSide,result[i+1][j+1]);//指的是边长
                }
            }
        }
        return maxSide*maxSide;
    }
}