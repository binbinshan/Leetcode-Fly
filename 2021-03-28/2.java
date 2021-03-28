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
 //时间复杂度O(n),空间复杂度O(n)
 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(-1,null);
        ListNode result = list;
        int tmp = 0;
        while(l1 != null || l2 != null || tmp != 0){
            if(l1 != null){
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                tmp += l2.val;
                l2 = l2.next;
            }
            list.next = new ListNode(tmp % 10,null);
            tmp = tmp/10;
            list = list.next;
        }
        return result.next;
    }
}