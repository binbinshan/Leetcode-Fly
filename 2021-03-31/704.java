
//递归 二分查找 前提是数组且有序  时间复杂度O(logn) 空间复杂度O(logn)
class Solution {
    public int search(int[] nums, int target) {
        return midrr(nums,0,nums.length -1 ,target);
    }
       public int midrr(int[] nums,int left,int right,int target){
        //左下标 必须 小于等于右下标 才能进入判断
        if(left <= right){
            int mid = (left+right) >>> 1;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]){
                return midrr(nums,left,mid -1,target);
            }else{
                return midrr(nums,mid+1,right,target);
            }
        }else{
            return -1;
        }
    }
}



//迭代 二分查找 前提是数组且有序 ，时间复杂度O(logn) 空间复杂度O(1)
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0 ,right = n - 1;

        while(left <= right){
            int mid = (left+right) >>> 1;
            if(nums[mid] == target){
                return mid;
            }

            if(target < nums[mid]){
                right = mid - 1; 
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}