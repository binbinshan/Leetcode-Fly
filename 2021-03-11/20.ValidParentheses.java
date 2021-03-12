//时间复杂度O(n) 空间复杂度O(n)
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1)return false;

        Stack<Character> stack = new Stack();

          Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        //循环所有的字符
        //如果是右括号，就获取栈顶一个符号比较，如果不同直接false 如果相同出栈，进行下一个符号比较
        //如果是左括号，就入栈
        //最后字符都循环完了，并且栈中也没有左边符号了 就说明全匹配上了，否则就是没有
        for(int i=0; i < n ;i++){
            char c = s.charAt(i);
            if(pairs.containsKey(c)){
                if(stack.isEmpty() || (stack.peek() != pairs.get(c))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}