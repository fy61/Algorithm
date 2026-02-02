package Linked;
import Utils.InputUtil;
import Utils.OutputUtil;

/**
 * 反转链表
 */
public class Hot100_206 {
    public static void main(String[] args) {
        ListNode head = InputUtil.createListFromConsole();
        ListNode result = reverseList(head);
        OutputUtil.printList(result);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
