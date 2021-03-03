/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //可以将两个指针走过的路程看成三部分：A链表没有相交的部分、B链表没有相交的部分、相交的部分。只是这两个指针走过这三个部分的顺序是不一样的额，指针pa先走 A链表没有相交的部分 ，指针pb先走 B链表没有相交的部分，两个指针都经过三个部分后，指针走过的长度一定是相同的，因为如果相交的话下一次遍历的时候两个指针一定相遇。
 
 public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //头结点为空 则肯定不会相交，返回Null
        if(headA == null || headB == null) return null;

        //定义两个指针，分别从 a b 链表开始
        ListNode pa = headA;
        ListNode pb = headB;

        while( pa != pb){
            //指针分别往后走
            pa = pa.next;
            pb = pb.next;

            //说明都为空则表示没有相交 直接返回 null
            if(pa == null && pb == null){
                return null;
            }

            //单个为空到另一个链表头节点 继续
            if(pa == null){
                pa = headB;
            }
            if(pb == null){
                pb = headA;
            }
        }
        return pa;
    }
}