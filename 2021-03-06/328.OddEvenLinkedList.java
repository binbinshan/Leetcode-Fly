package com.cbay.java8;

public class LinkTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode = new ListNode(1,listNode2);

        solution.oddEvenList(listNode);

    }

    //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    //第一个元素永远是奇数，第二个元素永远是偶数，依次类推
    //结果是用两个链表组合，一个奇数链表 一个偶数链表， 偶数追加在奇数后面
    //定义两个指针，一个odd指向head 一个指向一个复制的链表temp 也就是hean.next
    //只要偶数节点不为null，就可以一直循环
    //把奇数节点的下一节点 赋值为偶数的下一节点，然后奇数往后移动一位
    //把偶数节点的下一节点 赋值为奇数的下一节点，然后偶数往后移动一位
    //退出循环 拼接返回
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode temp = head.next;
            //奇数
            ListNode odd = head;
            //偶数
            ListNode even = temp;

            while(even != null && even.next != null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = temp;
            return head;
        }
    }
}
