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
 //定义指针per为null，定义cur为头指针
 //每次都把cur下一节点存起来
 //然后把cur的下一节点指向per,这个时候两个节点的顺序就反转了
 //继续往下走，就把per指向cur当前节点，cur指向刚才存起来的临时变量，也就是没有反转之前的cur节点的下一节点
 //走到最后，如果cur为Null，则表示已经到链表最后节点了，就可以退出了，
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode per = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = per;
            per = cur;
            cur = temp;
        }
        return per;
    }
}