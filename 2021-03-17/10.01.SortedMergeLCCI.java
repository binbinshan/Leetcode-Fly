
//时间复杂度O（m+n）,空间复杂度O（1）
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = n + m - 1;
        int cur;
        //定义两个指针 一个A的元素长度 一个B的元素长度，
        //只有两个指针都等于0时才会退出
        while(pa >= 0 || pb >= 0){
            //如果指针a等于-1时，说明a数组已经循环完了，只能把b当前指针放入合并后的数组元素位
            if(pa == -1){
                cur = B[pb];
                pb--;
            //如果指针b等于-1时，说明b数组已经循环完了，只能把a当前指针放入合并后的数组元素位
            }else if(pb == -1){
                cur = A[pa];
                pa--;
            //如果指针a当前元素小于指针b当前元素，就把b当前指针放入合并后的数组元素位
            }else if(A[pa] < B[pb]){
                cur = B[pb];
                pb--;
            //如果指针b当前元素小于指针a当前元素，就把a当前指针放入合并后的数组元素位
            }else{
                cur = A[pa];
                pa--;
            }
            //把循环过后的元素值赋值到数组倒序的 位置上
            A[tail] = cur;
            //合并数组 元素指针 往前走一步
            tail--;
        }

    }
}




------------

//快速排序
//时间复杂度O(n的平方)
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
       
        for (int i = 0; i != n; ++i) {
            A[m + i] = B[i];
        }
        int maxIndex;
        for(int i = 0; i < m + n - 1 ; i++){
            maxIndex = i ;
                for(int j = i + 1; j < m + n ; j++){
                    if(A[maxIndex] > A[j] ){
                        maxIndex = j;
                    }
                }
            int temp = A[maxIndex];
            A[maxIndex] = A[i];
            A[i] = temp;
        }
    }
}