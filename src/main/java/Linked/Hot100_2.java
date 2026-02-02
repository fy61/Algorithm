package Linked;

import Utils.InputUtil;
import Utils.OutputUtil;

/**
 * 两数相加
 */
public class Hot100_2 {
    public static void main(String[] args) {
        ListNode list1 = InputUtil.createListFromConsole();
        ListNode list2 = InputUtil.createListFromConsole();
        ListNode result = addTwoNumbers(list1, list2);
        OutputUtil.printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        // 2. 只要 l1, l2 没走完，或者还有进位没处理完，就继续循环
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            // 计算当前位的总和及新的进位
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
