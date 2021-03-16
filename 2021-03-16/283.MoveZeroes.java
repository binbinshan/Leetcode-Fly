
//最基本的冒泡排序写法 冒泡时间复杂度都是 n的平方
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int n = arr.length;
        //默认设置为 发生交换 为 true
        boolean swapFlag = true;
        for(int i = 0; i < n-1 ; i++){
            //判断如果上次没有发生交换，就退出循环了
            if(!swapFlag)break;

            swapFlag = false;
            for(int j =0 ; j < n-1-i; j++ ){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //交换过 设为true
                    swapFlag = true;
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