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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return head;
        if(head.next == null)return head;
        //哨兵节点
        ListNode dummyHead = new ListNode(-1,head);
        //指针
        ListNode cur = dummyHead;
        
        while(cur.next != null && cur.next.next != null){
            //如果下一节点的值 等于 下下一节点的值 
            if(cur.next.val == cur.next.next.val){
                //就定义个标准值
                int x = cur.next.val;
                //循环判断下一节点不为null并且下一节点的值等于标准值
                while (cur.next != null && cur.next.val == x) {
                    //把当前指针的下一节点 指向下下一节点， 继续循环
                     cur.next = cur.next.next;
                }
            }else{
                //挪到下一节点
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}