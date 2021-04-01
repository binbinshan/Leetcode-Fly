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

//时间复杂度O(logn),空间复杂度O(1)
class Solution {
    public int findMin(int[] nums) {

       int left = 0,right = nums.length-1;

        while(left < right){
            int mid = (left + right) / 2;
             if(nums[mid] < nums[right]){
                right = mid;
             }else{
                 left = mid + 1;
             }
        }
        return nums[left];
    }

}