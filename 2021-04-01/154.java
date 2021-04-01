//时间复杂度O(logn),空间复杂度O(logn)
class Solution {
    public int findMin(int[] nums) {

       return findMin(nums,0,nums.length-1);
    }

    public int findMin(int[] nums,int left ,int right){
        if (left+1 >= right){
            return Math.min(nums[left], nums[right]);
        }

        if(nums[left] < nums[right])return nums[left];

        int mid = (left + right + 1) / 2;

        
        return Math.min((findMin(nums,left,mid-1)),(findMin(nums,mid,right)));
    }
}
