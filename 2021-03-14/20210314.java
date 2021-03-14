
//344. 反转字符串 时间复杂度O(n),空间复杂度O(n)
class Solution {
    public void reverseString(char[] s) {
        helper(0,s.length-1,s);
    }

    private void helper(int sindex, int eindex,char [] str) {
        if (str == null || sindex >= eindex) {
            return;
        }
        char temp = str[sindex];
        str[sindex] = str[eindex];
        str[eindex] = temp;
        helper(sindex + 1, eindex - 1,str);
    }
}



//24. 两两交换链表中的节点 时间复杂度O(n),空间复杂度O(n)
class Solution {

    public ListNode swapPairs(ListNode head) {
         return swap(head);
    }

    private ListNode swap(ListNode head){
         if(head == null || head.next == null){
            return head;
        }
        ListNode after = head.next;
        head.next = swap(after.next);
        after.next = head;
        return after;
    }
}