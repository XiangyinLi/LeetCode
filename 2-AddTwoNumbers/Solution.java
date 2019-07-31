class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        while (cur1 != null || cur2 != null) {
            int num1 = cur1 != null ? cur1.val : 0;
            int num2 = cur2 != null ? cur2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
        }
        // 不要遗忘可能的最后一次进位
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
}