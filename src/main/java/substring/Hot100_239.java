package substring;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import static Utils.inputUtil.getIntArrayFromConsole;

/**
 * 滑动窗口的最大值
 */
public class Hot100_239 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数K");
        int k = scanner.nextInt();
        int[] nums = getIntArrayFromConsole();
        int[] result = maxSlidingWindow(nums,k);
        for (int i : result) {
            System.out.print(i + " ");
        }
        scanner.close();
    }
    public static int[] maxSlidingWindow(int[] nums, int k){

        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            //窗口的边界为 [i-k+1,i] 如果 堆中最大值的下标 pq.peek()[1] < i-k+1 他就过期了，就需要踢出去
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
