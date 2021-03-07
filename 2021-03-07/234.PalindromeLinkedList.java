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
 //获取中间节点，得到右半部分链表 ，翻转右半部分链表
 //比较左右链表
 class Solution {
    public boolean isPalindrome(ListNode head) {
            if(head == null)return true;
            
            ListNode leftEndNode = leftEndNode(head);
            ListNode rightLinkList = reverseLinkList(leftEndNode.next);

            ListNode p1 = head;
            ListNode p2 = rightLinkList;
            boolean result = true;
            while(result && p2 != null){

                if(p1.val == p2.val){
                    p1 = p1.next;
                    p2 = p2.next;
                }else {
                    result = false;
                }
            }
            return  result ;
        }


        private ListNode leftEndNode(ListNode head){
            ListNode slow = head;
            ListNode fast = head;

            while(fast.next != null && fast.next.next != null ){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;

        }

        private ListNode reverseLinkList(ListNode head){
            ListNode per = null;
            ListNode cur = head;

            while (cur != null){
                ListNode temp = cur.next;
                cur.next = per;
                per = cur ;
                cur = temp;
            }
            return per;
        }

}