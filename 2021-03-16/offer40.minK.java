

//最基本的冒泡排序写法 冒泡时间复杂度都是 n的平方
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int n = arr.length;
        for(int i = 0; i < n-1 ; i++){
            for(int j =0 ; j < n-1-i; j++ ){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        int[] arr1 = new int[k];
        for(int i = 0; i < k ; i++){
            arr1[i] = arr[i];
        }
        return arr1;

    }
}



