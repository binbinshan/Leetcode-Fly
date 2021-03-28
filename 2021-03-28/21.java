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
 //时间复杂度O(m+n) ，空间复杂度O（m+n）
 //递归处理
 class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preNode = new ListNode(-1);
        ListNode pre = preNode;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l2 == null ? l1 : l2;

        return preNode.next;
          
    }
}