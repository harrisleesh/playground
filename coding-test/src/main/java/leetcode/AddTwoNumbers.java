package leetcode;

import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {

    }

    static class Solution {
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode();
            addTwoNumbers(listNode, l1, l2, 0);
            return listNode;
        }

        private void addTwoNumbers(ListNode listNode, ListNode l1, ListNode l2, int moreThanTen) {
            int moreThanTenThis = 0;
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            if(l1Val + l2Val + moreThanTen < 10){
                listNode.val = l1Val + l2Val + moreThanTen;
            }
            else{
                listNode.val = l1Val + l2Val + moreThanTen - 10;
                moreThanTenThis = 1;
            }

            ListNode l1Next = l1 != null ? l1.next : null;
            ListNode l2Next = l2 != null ? l2.next : null;
            if(l1Next != null || l2Next != null){
                listNode.next = new ListNode();
                addTwoNumbers(listNode.next, l1Next, l2Next, moreThanTenThis);
            }
            else if(moreThanTenThis == 1){
                listNode.next = new ListNode();
                listNode.next.val = 1;
            }
        }
    }
}
