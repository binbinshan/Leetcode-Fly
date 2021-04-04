//时间复杂度O(logn) 空间复杂度O(1)
class Solution {
    public boolean search(int[] nums, int target) {
 int left = 0;
        int right = nums.length - 1;

        if(nums.length == 0)return false;
        if(nums.length == 1) {
            return nums[0] == target ? true : false;
        }
        while(left <= right){
            int mid = left + ((right- right) >>> 1);
            if(nums[mid] == target){
                return true;
            }
            //重复元素的过滤
            if(nums[left] == nums[mid]){
                left++;
                continue;
            }
            
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid] > target ){
                    right = mid -1 ;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[right] >= target && nums[mid] < target ){
                    left = mid+1 ;
                }else{
                    right = mid -1;
                }
            }
        }
        return false;
    }
}