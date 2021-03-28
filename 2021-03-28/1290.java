/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //时间复杂度O(n) 空间复杂度O（1）  翻转数组 -> 循环
 class Solution {
    public int getDecimalValue(ListNode head) {

        ListNode rNode =  reversal(head);

        int count = calc(rNode,0,0);

        return count;
    }
    private int calc(ListNode head,int n,int sum){
        if(head == null) return 0;

        while(head != null){
             if(head.val == 1){
                 sum = sum + (int)Math.pow(2,n);
            }
            n++;
            head = head.next;
        }
        return sum;
    }
    private ListNode reversal(ListNode head){
        if(head.next == null)return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;

        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }


}