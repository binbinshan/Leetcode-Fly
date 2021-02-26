class Solution {
    public void setZeroes(int[][] matrix) {
        //创建两个数组分别记录为0的行和列
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[] row = new boolean[r];
        boolean[] col = new boolean[c];

        //循环判断数组元素是否为0，为0 就给对应的行和列 附上true
        for(int i=0; i < r ; i++){
            for(int j=0; j < matrix[i].length ; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
            //循环判断行和列是否为ture， 赋值为0
        for(int i=0; i < r ; i++){
                for(int j=0; j < matrix[i].length ; j++){
                    if(row[i] || col[j]){
                        matrix[i][j] = 0;
                    }
                }
        }

    }
}