//时间复杂度O(nm) 矩阵中的每个元素都要被访问一次。 空间复杂度O(1)
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        //定义x,y 为矩阵左上角， 定义m-1,n-1为矩阵右下角
        int x = 0, y = 0, m = matrix.length, n = matrix[0].length;
        //开始处理
        calc(arr,x,y,m-1,n-1,matrix);
        return arr;
    }

    public void calc(List arr,int x,int y,int x1,int y1,int[][] matrix){
        //递归退出条件，当右下角小于左上角的时候 退出递归
        if (x1 < x || y1 < y) return;
        //只有一行
        if(x1  == x){
            for(int i = y ;i <= y1; i++){
                arr.add(matrix[x][i]);
            }
            return;
        }
        //只有一列
        if(y1  == y){
            for(int i = x ;i <= x1; i++){
                arr.add(matrix[i][y]);
            }
            return;
        }   
        //上方
        for(int i = y; i < y1 ; i++){
            arr.add(matrix[x][i]);
        }
        //右方
        for(int i = x; i < x1 ; i++){
            arr.add(matrix[i][y1]);
        }
        //下方
        for(int i = y1; i > y ; i--){
            arr.add(matrix[x1][i]);
        }
        //左方
        for(int i = x1; i > x ; i--){
            arr.add(matrix[i][y]);
        }
        //左上角和右下角的坐标都往里缩进，循环内圈
        calc(arr,x+1,y+1,x1-1,y1-1,matrix);
    }
}