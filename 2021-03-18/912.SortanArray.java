class Solution {
    public int[] sortArray(int[] nums) {
        //开始递归调用
        quickSort(nums,0,nums.length -1);
        return nums;
    }

    public static void quickSort(int[] arr, int start, int end) {
        //如果分区中的元素少于两个，退出
        if(start >= end) return;
        //获取中间值下标
        int index = partition(arr,start,end);
        //左区间
        quickSort(arr,start,index - 1);
        //右区间
        quickSort(arr,index + 1,end);
    }

    public static int partition(int[] arr, int start, int end) {
        //获取第一个元素作为 基准点
        int pivot = arr[start];
        //左指针，从第二个元素开始分区
        int left = start + 1;
        //右指针
        int right = end;

        //左指针小于右指针循环
        while(left < right){
            //如果左指针小于右指针 并且 左指针对应的值小于等于基准值，就往后移动左指针
            //当左指针对应的值大于基准值是就会退出while
            while(left < right && arr[left] <= pivot) left++;
            //如果左指针小于右指针 并且 右指针对应的值大于等于基准值，就往前移动右指针
            //当右指针对应的值小于基准值是就会退出while
            while (left < right && arr[right] >= pivot) right--;
            //此时左指针指的就是比基准大的数，右指针指的就是比基准小的数
            //此时就交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left < right) {
                exchange(arr, left, right);
                //左指针继续向右移动
                left++;
                //右指针继续向左移动
                right--;
            }
          }
            // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
            if (left == right && arr[right] > pivot) right--;
            // 将基数和轴交换
            exchange(arr, start, right);
            return right;
        }


    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}