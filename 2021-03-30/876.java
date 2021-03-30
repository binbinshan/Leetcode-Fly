/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //时间复杂度O(n) 空间复杂度O(1)
 class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode k = head;
        ListNode m = head;

        while(k != null && k.next !=null){
            k = k.next.next;
            m = m.next;
        }
        return m;
    }
}