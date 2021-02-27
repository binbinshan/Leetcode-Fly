 public static int[] findDiagonalOrder(int[][] matrix) {
        //如果原数组为0，直接返回
        if (matrix.length == 0) {
            return new int[0];
        }
        //原数组行
        int rowLength = matrix.length;
        //原数组列
        int columnLength = matrix[0].length;

        //定义新数组，为原数组个数的乘积
        int[] answer = new int[rowLength * columnLength];
        
        //对于m*n个元素的数组来说，共需要 (M+N)-1 次方向变更
        int count = rowLength + columnLength - 1;
        
        //定义m 行
        int m = 0;
        //定义n 列
        int n = 0;
        //新数组下标
        int answerIndex = 0;

        //总循环次数为 (M+N)-1 次
        for (int i = 0; i < count; i++) {
            //被2整除代表 右上
            if (i % 2 == 0) {
                //如果m(行) >=0 且 n(列) < 原数组的列，即代表可继续右上
                while (m >= 0 && n < columnLength) {
                    //赋值
                    answer[answerIndex] = matrix[m][n];
                    //新数组下标+1
                    answerIndex++;
                    //右上的话 行就要-1 列就要+1
                    m--;
                    n++;
                }
                //如果此时 m(行) 小于0 ，n(列) 还没有到达最后一列 就需要把行+1 继续执行
                if (n < columnLength) {
                    m++;

                //如果此时 m(行) 小于0 ，n(列) 还>= 最后一列 , m需要加2，n--即可
                } else if(n >= columnLength) {
                    m = m + 2;
                    n--;
                }

                //不能整除代表 左下
            } else {
                while (m < rowLength && n >= 0) {
                    answer[answerIndex] = matrix[m][n];
                    answerIndex++;
                    m++;
                    n--;
                }
                //如果 n < 0 , m(行) < 原数组行 , 就n(列) + 1 ，到下一列
                if (m < rowLength) {
                    n++;
                    
                //如果 列小于0 ，m(行) >= 最后一行 ， m就需要-1 n+2 
                }else if(m >= rowLength){
                    m--;
                    n=n+2;
                }

            }
        }
        return answer;


    }
