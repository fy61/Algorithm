import java.util.Scanner;

public class Hot100_283 {
    public static void main(String[] args) {
        int[] nums = getIntArrayFromConsole();
        int len = nums.length;
        int right = 0;
        int left = 0;
        while (right < len) {
            if (nums[right] != 0){
                exchange(nums,right,left);
                left++;
            }
            right++;
        }
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    public static void exchange(int[] nums, int right, int left) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static int[] getIntArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整型数组（格式示例：1,2,3,4,5，多个数字用英文逗号分隔）：");
        String input = scanner.nextLine().trim();

        // 处理空输入
        if (input.isEmpty()) {
            scanner.close();
            return new int[0];
        }

        // 按英文逗号分割为字符串数组
        String[] strArray = input.split(",");
        int[] intArray = new int[strArray.length];

        // 遍历转换为整型，同时去除每个元素的首尾空格
        for (int i = 0; i < strArray.length; i++) {
            String numStr = strArray[i].trim();
            try {
                // 将字符串转换为整数
                intArray[i] = Integer.parseInt(numStr);
            } catch (NumberFormatException e) {
                // 处理非数字输入的情况
                System.err.println("输入错误：'" + numStr + "' 不是有效的整数，请重新输入！");
                scanner.close();
                // 可选择返回空数组或抛出异常，这里返回空数组
                return new int[0];
            }
        }

        scanner.close();
        return intArray;
    }
}
