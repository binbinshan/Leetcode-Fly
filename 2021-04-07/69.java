//时间复杂度O(logn) ，空间复杂度O(1)
class Solution {
    public int mySqrt(int x) {
        if(x == 0)return 0;

        int left = 1;
        int right = x / 2;

        while(left < right){
            //向上取中间数
            int mid = left + ( ( right - left +1) >>>1);
            //大于时 就从中间数之前寻找 
            if(mid  > x / mid){
                right = mid - 1;
            }else{
                left = mid ;
            }
        }
        return left;
    }
}