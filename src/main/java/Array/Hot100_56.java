package Array;

import java.util.*;

import static Utils.inputUtil.inputTwoDimensionalArray;

/**
 * 合併區間
 */
public class Hot100_56 {
    public static void main(String[] args) {
        int[][] intervals = inputTwoDimensionalArray();
        int[][] result = merge(intervals);
        System.out.println("\n合并区间数组：");
        for (int i = 0; i < Objects.requireNonNull(result).length; i++) {
            int[] row = result[i];
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    public static int[][] merge(int[][] intervals) {
        if(intervals.length <=1) return intervals;
        // 排序,让起点有序
        //接收一个 Lambda 表达式作为参数
        //作用是告诉程序：“不管数组里存的是什么，请提取出索引为 0 的那个整数作为排序的依据
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        //处理后 无重叠的区间
        List<int[]> merged = new ArrayList<>();
        // 把第一根线放进去作为一个基准
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1]; //基准线的屁股
            int nextStart = interval[0]; //新线的头
            int nextEnd = interval[1]; //新线的屁股
            if(nextStart <= currentEnd){
                currentInterval[1] = Math.max(currentEnd,nextEnd);
            }else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
