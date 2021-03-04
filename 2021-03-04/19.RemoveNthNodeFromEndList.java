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

//定义了一在原来链表基础上多了一个哨兵节点的链表
//将per指针指向头节点，cur指向哨兵节点
//先让per走n-1个位置，然后per再和cur一起走，这样当per到达链表尾节点的时候，cur的下一节点就是需要删除的节点。
//删除节点后，返回的链表为去掉哨兵节点的链表
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0,head);

        ListNode per = head;
        ListNode cur = dummyHead;

        while(n-1 > 0){
            n--;
            per = per.next;
        }
        while(per.next != null){
            cur = cur.next;
            per = per.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummyHead.next;

        return ans;
    }
}