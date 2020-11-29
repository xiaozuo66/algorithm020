class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length==0){
            return new int[0];
        }
        // if(k>nums.length){
        //     int result[]=new int[1];
        //     result[0]=getMax(nums,0,nums.length);
        //     return result;
        // }
        if(k==1){
            return nums;
        }

        int result[]=new int[nums.length-k+1];

        //1、双指针
        // int left=0;
        // int right=left+k;
        // int index=0;
        // while(right<=nums.length){
        //     result[index++]=getMax(nums,left++,right++);
        // }
        //2、双向队列：队列用来保存元素索引
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            //注意等于边界值
            while(!queue.isEmpty() && nums[i]>=nums[queue.peekLast()]){
                queue.pollLast();//获得队尾元素并删除
            }
            queue.addLast(i);//队尾添加
            //已经被窗口划过的元素，可能还保留在queue中，比如[7,2,4]，7永远比后面的元素大，在上面的while循环中不会被删除，所以需要根据索引去掉失效的元素，即去掉上个窗口的最大值，所以队列中的元素不会超过两个。
            if(queue.peek() <= i-k){
                queue.poll();
            } 
            //注意等于边界值
            if(i+1>=k){//表示已经出现了窗口，但是队列中可能不是k个元素，同时，队首肯定是当前窗口的最大值
                result[i-k+1]=nums[queue.peek()];//这里不能用poll，因为还要留下来跟下一个元素比较
            }
        }
        return result;
    }

    private int getMax(int nums[],int start,int end){
        int temp=0;
        for(int i=start;i<end;i++){
            temp=Math.max(temp,nums[i]);
        }
        return temp;
    }
}