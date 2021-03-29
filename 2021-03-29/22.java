/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //快慢指针 时间复杂度O(n) 空间复杂度O(1)
 class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
            if(head == null || head.next == null)return head;

            ListNode y = head;
            ListNode m = head;

            for(int i = 0 ; i < k ; i++){
                y = y.next;
            }
            while(y != null){
                y = y.next;
                m = m.next;
            }
            return m;
    }
}