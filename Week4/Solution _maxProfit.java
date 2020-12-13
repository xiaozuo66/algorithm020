//理解贪心算法的应用场景
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int sum=0;
        //理解其本质就是遇到大的就减就行，出现小的减出负数则取0
        for(int i=1;i<prices.length;i++){
            sum+=Math.max(0,prices[i]-prices[i-1]);
        }
        return sum;
    }
}