package Linked;

import Utils.InputUtil;
import Utils.OutputUtil;

/**
 * 相交链表(长度差对齐法)
 */
public class Hot100_160 {
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // 1. 分别计算两个链表的长度
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode pA = headA;
        ListNode pB = headB;

        // 2. 让长的链表指针先走 diff 步
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff-- > 0) pA = pA.next;
        } else {
            int diff = lenB - lenA;
            while (diff-- > 0) pB = pB.next;
        }

        // 3. 此时两个指针同步起跑，寻找相遇点
        while (pA != null && pB != null) {
            if (pA == pB) return pA; // 找到内存地址相同的节点
            pA = pA.next;
            pB = pB.next;
        }

        return null; // 遍历完都没相遇，说明不相交
    }

    // 辅助方法：获取链表长度
    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
