package Linked;

import Utils.InputUtil;
import Utils.OutputUtil;

/**
 * 相交链表(双指针交换法)
 */
public class Hot100_160_1 {
    /**
     * 主代码模拟力扣系统，无法实现不相交情况
     * @param args
     */
    public static void main(String[] args) {
        // 1. 先构建公共部分 [8, 4, 5]
        System.out.println("请输入公共部分的内容（如 8,4,5）：");
        ListNode common = InputUtil.createListFromConsole();

        // 构建链表 A
        System.out.print("构建链表 A：");
        ListNode headA = InputUtil.createListFromConsole();

        // 构建链表 B
        System.out.print("构建链表 B：");
        ListNode headB = InputUtil.createListFromConsole();

        // 2. 安全拼接链表 A
        if (headA == null) {
            headA = common; // 如果 A 本身为空，直接让 headA 指向公共部分
        } else {
            ListNode tempA = headA;
            // 循环条件增加 tempA != null 判断（虽然上面 if 已过滤，但这是好习惯）
            while (tempA.next != null) {
                tempA = tempA.next;
            }
            tempA.next = common;
        }

        // 3. 安全拼接链表 B
        if (headB == null) {
            headB = common; // 如果 B 本身为空，直接让 headB 指向公共部分
        } else {
            ListNode tempB = headB;
            while (tempB.next != null) {
                tempB = tempB.next;
            }
            tempB.next = common;
        }

        // 打印确认
        System.out.print("您输入的链表 A: ");
        OutputUtil.printList(headA);
        System.out.print("您输入的链表 B: ");
        OutputUtil.printList(headB);

        // 只有当两个头结点都不为空时，寻找相交节点才有意义
        if (headA == null || headB == null) {
            System.out.println("其中一个链表完全为空，相交节点为：null");
        } else {
            ListNode res = getIntersectionNode(headA, headB);
            System.out.print("找到的相交节点起始为: ");
            OutputUtil.printList(res);
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {// 如果其中一个是空，肯定不相交
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // 只要两个指针不相等，就持续循环
        // 如果相交，它们会在交点相遇 (pA == pB)
        // 如果不相交，它们会同时指向 null (pA == pB == null)
        while (pA != pB) {
            // pA 走一步。如果走到头了，就去接 B 链表的头
            pA = (pA == null) ? headB : pA.next;

            // pB 走一步。如果走到头了，就去接 A 链表的头
            pB = (pB == null) ? headA : pB.next;
        }

        // 循环结束时，pA 就是我们要找的交点（或者是 null）
        return pA;
    }

}
