class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    //  技能只会将生气变为不生气，没有生气的还是没有生气。
    //  我们可以先求和原本就满意的客户，同时将对应的满意的客户 customers[i] 设置为 0
    //  之后的问题转化为在customers 中找到连续一段长度为 x 的子数组，使得其总和最大。
    //  原本满意的客户 + 发动技能最大满意客户数

    int count = 0;
    //获取没有生气时的所有客户数量
    for (int i = 0; i < customers.length; i++) {
        if (grumpy[i] == 0) {
            count += customers[i];
            //将没有生气的客户数置为0
            customers[i] = 0;
        }
    }

    //最大值
    int max = 0;
    //当前值
    int cur = 0;
    for (int now = 0, old = 0; now < customers.length; now++) {
        //循环获取生气的客户
        cur += customers[now];
        //元素个数超过X，就把已经上面累加的值减去，
        if (now - old + 1 > X) {
            cur -= customers[old];
            //old+1
            old++;
        }
        max = Math.max(max, cur);
    }
        return count + max;
    }
}