class Solution {
    public int numDecodings(String s) {
        if("".equals(s) || s==null){
            return 0;
        }
        //从第二个数字开始处理，所以初始值都设置为1
        int result=0;
        int pre=0;
        char temp[]=s.toCharArray();
        for(int i=0;i<temp.length;i++){
            if(i>0){
                //判断当前位置数字能不能与前一个合并
                if(temp[i-1]=='1' || (temp[i-1]=='2' && temp[i]<='6')){
                    //前一位是1 或者前一位是2并且当前位置<=6
                    if(temp[i]=='0'){
                        //如果当前是0，则只可能与前一位一起使用，即解码方法数不变
                        result=pre;
                    }else{
                        result=pre+1;
                    }
                }else{
                    result=pre+1;
                }
                pre=result;
            }else{
                if(temp[i]==0){
                    pre=0;
                }else if(temp[i]){
                    
                }
            }
            
        }
        return result;
    }
}