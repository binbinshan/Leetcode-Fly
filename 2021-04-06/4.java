//时间复杂度O(logn) 空间复杂度O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        //如果num1 大于 nums2 ,重新调用，扫描数组元素少的数组
        if(lenA > lenB){
            return findMedianSortedArrays(nums2,nums1);
        }
        //如果num1 元素个数为0,直接返回num2的中位数
        if(lenA == 0)return ((double)nums2[(lenB - 1)/2]+nums2[(lenB)/2])/2;
        //二分查找区间
        int nums1_start = 0,nums1_end = lenA ;
        int len = lenA + lenB ;
        //数组A和数组b分别用到的元素个数
        int cur1 = 0 , cur2 = 0;
        while(nums1_start <= nums1_end){
            cur1 = nums1_start + ((nums1_end - nums1_start)>>>1);
            //根据cur1 得出 cur2
            cur2 = (len + 1) / 2 - cur1;

            double l1 = (cur1 == 0) ? Integer.MIN_VALUE : nums1[cur1 -1 ];
            double l2 = (cur2 == 0) ? Integer.MIN_VALUE : nums2[cur2 -1 ];
            double r1 = (cur1 == lenA) ? Integer.MAX_VALUE : nums1[cur1];
            double r2 = (cur2 == lenB) ? Integer.MAX_VALUE : nums2[cur2];
            //l1 <= r2 && l2 <= r1，则成立
            if(l1 > r2){
                nums1_end = cur1 - 1;
            }else if(l2 > r1){
                nums1_start = cur1 + 1;
            }else{
                if(len % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                }else{
                    return Math.max(l1,l2);
                }
            }
        }
            return -1;
    }
}