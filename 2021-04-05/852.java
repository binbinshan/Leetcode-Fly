//时间复杂度O(logn) 空间复杂度O(1)
//左下标 等于 右下标时 ，返回
//中间值大于下一节点值，就把右指针 指向中间指针,反之左指针指向中间指针
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = left + ((right - left)>>>1);
            if(arr[mid] > arr[mid+1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}