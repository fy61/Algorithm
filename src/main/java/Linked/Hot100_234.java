package Linked;

import Utils.InputUtil;
import Utils.OutputUtil;

import java.util.Stack;

/**
 * 回文链表
 */
public class Hot100_234 {
    public static void main(String[] args) {
        ListNode head = InputUtil.createListFromConsole();
        boolean result = isPalindromeTwo(head);
        System.out.println(result ? "是回文" : "不是回文");
    }
    static public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        // 1. 建立一个栈，用于存放链表的值
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            // 栈顶弹出的是原链表的“末尾”，依次往前
            if (curr.val != stack.pop()) {
                return false; // 只要有一个不等，就不是回文
            }
            curr = curr.next;
        }

        return true;
    }

    static public boolean isPalindromeTwo(ListNode head){
        if (head == null || head.next == null) return true;

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return result;
    }
     // 辅助函数：快慢指针找中点
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    // 辅助函数：三指针法反转链表（你之前学的）
    private static ListNode reverseList(ListNode head) {
        ListNode prev =null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;

    }
}
