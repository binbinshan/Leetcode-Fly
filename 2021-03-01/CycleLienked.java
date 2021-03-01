/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       //首节点为null 或者 首节点的下一节点为null 直接返回false
       if(head == null || head.next == null) return false;
       //初始化 慢指针
       ListNode slow = head;
       //初始化 快指针
       ListNode fast = head.next;
       //如果对象不相等 就继续走
       while(fast != slow){
        //如果快指针到下一个节点为null,代表到最后了 就说明没有环
        if (fast == null || fast.next == null) {
                return false;
            }
            //慢指针继续往下走 一步
            slow = slow.next;
            //慢指针继续往下走 二步
            fast = fast.next.next;
       }
        return true;
}
}