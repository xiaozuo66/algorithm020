class Solution {
    public int[] plusOne(int[] digits) {
        //末尾非9的情况
        int end=digits[digits.length-1];
        if(end<9){
            digits[digits.length-1]=end+1;
        }else{
            for(int i=digits.length-1;i>=0;i--){
                //个位+1或者高位进位
                digits[i]++;
                digits[i]=digits[i]%10;//只取余数
                if(digits[i]!=0){
                    return digits;//无需进位，直接返回
                }else{
                    continue;
                }
            }
            //跳出for循环还没有返回值，表示最高位也是9，需要扩长度
            digits=new int[digits.length+1];
            digits[0]=1;//数组后面的值肯定都是0
        }
        return digits;
    }
}