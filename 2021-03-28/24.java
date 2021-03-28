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
  //时间复杂度O(n) 空间复杂度O(1)
  class Solution {
    public ListNode swapPairs(ListNode head) {
     if(head == null || head.next == null)return head;

     ListNode tmp = head.next;
     head.next = swapPairs(tmp.next);
     tmp.next = head;

     return tmp;
    }

}