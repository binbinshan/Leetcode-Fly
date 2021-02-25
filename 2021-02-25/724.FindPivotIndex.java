
class Solution {
    public int pivotIndex(int[] nums) {

        int rightSum = 0;
        //获得数组所有的数据，赋值给右元素
        for(int i = 0 ; i < nums.length ; i++ ){
             rightSum += nums[i];
        }

        int leftSum = 0 ;
        //循环数组 ，左边累加 右边累计减少 ，如果相同返回i，如果不同就-1
        for(int i = 0 ; i < nums.length ; i++ ){
             if(i > 0 ){
                leftSum += nums[i-1];
             }
             rightSum -= nums[i];

             if(leftSum == rightSum){
                 return i;
             }
        }
        return -1;
    }
}