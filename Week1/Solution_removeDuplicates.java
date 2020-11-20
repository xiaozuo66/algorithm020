class Solution {
    public int removeDuplicates(int[] nums) {

        //因为是有序的数组，所以，两个指针可以一起往后移动
        int i=0;//慢指针

        for(int j=1;j<nums.length;j++){
            
            if(nums[i]==nums[j]){
                //相等的话就让快指针向后移动
                continue;
            }else{
                //如果不相等，就把快指针所指向的元素移动到慢指针后面（不用考虑慢指针在什么位置，或者快慢指针相隔几个元素）
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}