package Linked;

import Utils.InputUtil;
import Utils.OutputUtil;

import java.util.List;

/**
 * 合并两个有序列表
 */
public class Hot100_21 {
    public static void main(String[] args) {
        ListNode list1 = InputUtil.createListFromConsole();
        ListNode list2 = InputUtil.createListFromConsole();
        ListNode result = mergeTwoListsTwo(list1, list2);
        OutputUtil.printList(result);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static ListNode mergeTwoListsTwo(ListNode list1, ListNode list2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = (list1 == null) ? list2 : list1;
        return prehead.next;
    }
}
