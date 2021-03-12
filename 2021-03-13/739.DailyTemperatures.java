//时间复杂度是O(n)，空间复杂度是O（n）
class Solution {
    public int[] dailyTemperatures(int[] T) {
        //定义一个栈 用来存放数组下标
        Stack<Integer> s = new Stack();
        int n = T.length;
        int[] res = new int[n];

    
        //循环数组，获取每个元素入栈
        for(int i=0 ; i < n ; i++){
            // 当栈不为空的时候 并且 当前数组中的数据 大于 栈顶的元素对应的数组元素时
            //就把栈顶元素出栈，然后把栈顶取出来的数组下标进行赋值
            //赋值为 当前元素的下标 减去 栈顶存的数组下标 ，也就计算出相隔最近的比较大的差
            while(!s.empty() && T[i] > T[s.peek()]){
                int pre = s.pop();
                res[pre] =  i - pre;
            }
            //如果不符合条件，就把当前数组下标入栈，进行下一个元素的比较。 直至栈空。
            s.push(i);
        }

        return res;
    }
}