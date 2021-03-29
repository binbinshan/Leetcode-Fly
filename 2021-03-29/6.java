/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//利用栈 先进后出，倒序  时间复杂度O(n) ，空间复杂度O(n)
class Solution {
    public int[] reversePrint(ListNode head) {

        LinkedList<Integer> stack = new LinkedList<Integer>();

        while(head != null){
            stack.addLast(head.val);
            head = head.next;
        }

        int  n = stack.size();
        int[] res = new int[n];
        
        for(int k = 0; k < n ; k++){
            res[k] = stack.removeLast(); 
        }

        return res;
    }


 
}