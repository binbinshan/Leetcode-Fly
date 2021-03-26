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
 //时间复杂度O(n) 空间复杂度O(1)，原地交换
 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null )return head;
        if(head.next == null)return head;

        ListNode cur = head;

        while(cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}