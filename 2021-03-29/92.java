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
 //时间复杂度O(n) 空间复杂度O(1),问题在于拼接 
 class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //构建哨兵节点的链表
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //指针
        ListNode pre = dummyNode;

       //找到要反转的链表之前第一个的元素
       for(int i = 0 ; i < left-1 ; i++){
           pre = pre.next;
       }
        //找到要反转的最后一个元素
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 反转链表的子区间
        reverse(leftNode);
        // 接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
        

    }

    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp ;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return head;
    }

}