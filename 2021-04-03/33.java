//时间复杂度O(logn) 空间复杂度O(1)
//旋转后的数组 也还是总有一边是完全排序的，排序的一句就是  左元素小于右端点元素,根据判断元素是否在当前区间  把另一半减去 减治
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if(nums.length == 0)return -1;
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while(left <= right){
            int mid = left + ((right- right) >>> 1);
            if(nums[mid] == target){
                return mid;
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
        return -1;
    }
}