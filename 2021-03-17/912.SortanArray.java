//时间复杂度O（n的平方）,空间复杂度O（1）
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        int minIndex;

        for(int i = 0 ; i < n - 1 ; i++){
            minIndex = i ;
            for(int j = i + 1 ; j < n ; j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }
}