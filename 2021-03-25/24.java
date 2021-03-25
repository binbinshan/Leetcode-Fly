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
 //时间福再度O(n) 空间复杂度O(n) 递归调用站的空间
 class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }

        ListNode next = head.next;

        head.next = swapPairs(next.next);

        next.next = head;

        return next;
    }

}