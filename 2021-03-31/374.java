//时间复杂度O(logn) 空间复杂度O（1）
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;

        while(left <= right){
            int mid = (left + right) >>> 1;
            int num = guess(mid);
            if(num == 0 )return mid;

            if(num == -1){
                right = mid - 1 ;
            }else{
                left = mid + 1 ;
            }
    }
    return 0;
    }
}