/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //定义一个伪头结点，per指向哨兵节点，cur指向头结点
 //开始遍历每个节点，如果cur不为null，就判断该节点是否等于给定的值
 //如果等于，则把per的下一节点指向cur的下一节点，这个当前节点值就相当于删除了
 //如果不等，则per等于cur
 //时间复杂度为O(N)  空间复杂度为O(1)
 class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode sentry = new ListNode(0,head);

        ListNode per = sentry;
        ListNode cur = head;

        while(cur != null){
            if(cur.val == val){
                per.next = cur.next;
            }else{
                per = cur;
            }
            cur = cur.next;
        }
        return sentry.next;
    }
}