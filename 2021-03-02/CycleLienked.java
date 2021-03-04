/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                //快慢指针，快指针每次走两步，慢指针每次走一步
                fast = fast.next.next;
                slow = slow.next;
                
                //先判断是否有环，
                if (slow == fast) { 
                    //确定有环之后才能找环的入口
                    while (head != slow) {
                        //两相遇指针，一个从头结点开始，
                        //一个从相遇点开始每次走一步，直到
                        //再次相遇为止
                        head = head.next;
                        slow = slow.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }