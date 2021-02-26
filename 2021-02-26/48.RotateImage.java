
class Solution {
    public void rotate(int[][] matrix) {

        int k = matrix.length;
        //创建临时数组 用于复制
        int[][] newT = new int[k][k];


        //该算法的公式为 old[i][j] = newT[j][k-i-1]
        for(int i=0 ; i < k ; i++){
            for(int j=0; j < k ;j++ ){
                newT[j][k-i-1] = matrix[i][j] ;
            }
        }
        for(int i=0 ; i < k ; i++){
            matrix[i] = newT[i];
        }
    }
}