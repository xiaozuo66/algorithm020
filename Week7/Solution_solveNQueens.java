class Solution {

    private List<List<String>> result=new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        if(n==0){
            return result;
        }
        //初始化二维数组
        char [][] con=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                con[i][j]='.';
            }
        }
        solve(con,0);
        return result;
    }

    private void solve(char [][] con,int row){
        if(row==con.length){
            //到了最后一行了
            result.add(construct(con));
            return;
        }
        //因为是n*n棋盘，所以这里列的范围用con.length也没问题，便于理解还是使用con[0].length
        for(int col=0;col<con[0].length;col++){

            // if(row==0){
            //     for(int i=0;i<con.length;i++){
            //         for(int j=0;j<con.length;j++){
            //             con[i][j]='.';
            //         }
            //     }
            // }

            if(valid(row,col,con)){
                //因为这里还是试错的思想，所以需要保留原始值，其实这里是回溯，只是二维数组不方便回退，而创建新的
                char [][]temp=copy(con);
                temp[row][col]='Q';
                solve(temp,row+1);
            }
        }
    }

    private boolean valid(int row,int col,char [][]chess){
        //第一种情况，判断该行以上的行是否存在皇后（同一列）
        for(int i=0;i<row;i++){
            if(chess[i][col]=='Q'){//同一列上已存在皇后
                return false;
            }
        }
        //第二种情况，判断左上角是否已存在皇后
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        //第三种情况，判断右上角是否已存在皇后
        for(int i=row,j=col;i>=0 && j<chess.length;i--,j++){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    private char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }

    //把数组转为list
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }
}