//时间复杂度O(n) 空间复杂度O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i=0; i < tokens.length ;++i){
            //如果是符号 就把栈顶的两个元素出栈进行计算（），并且将计算后的值重新放入栈中
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){               //出栈栈顶元素，并将出栈元素返回，作为公式的第二项
                int num1 = s.pop();
                 //出栈栈顶元素，并将出栈元素返回，作为公式的第一项
                int num2 = s.pop();
                if(tokens[i].equals("+")){
                    s.push(num2+num1);
                }else if( tokens[i].equals("-") ){
                    s.push(num2-num1);
                }else if( tokens[i].equals("*") ){
                    s.push(num2*num1);
                }else if(tokens[i].equals("/") ){
                    s.push(num2/num1);
                }
            }else{
                //不是符号，入栈
                s.push(Integer.valueOf(tokens[i]));
            }
        }
        return s.peek();
    }
}
