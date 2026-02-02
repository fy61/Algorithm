package Utils;

import Linked.ListNode;

import java.util.List;

public class OutputUtil {
    // 新增：格式化输出结果（匹配要求的输出格式）
    public static void printResult(List<List<String>> result) {
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            List<String> group = result.get(i);
            System.out.print("[");
            for (int j = 0; j < group.size(); j++) {
                System.out.print("\"" + group.get(j) + "\"");
                if (j < group.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < result.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    /**
     * 辅助方法：打印链表结构，方便调试可视化
     */
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}
