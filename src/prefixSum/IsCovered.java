package prefixSum;

public class IsCovered {

    public static void main(String[] args) {
        int[][] param = new int[3][4];
        param[0] = new int[]{1,2};
        param[1] = new int[]{3,4};
        param[2] = new int[]{5,6};
        boolean result = isCovered(param, 2, 5);
        System.out.println(result);
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        // 差分数组
        int[] diff = new int[52];
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        // 前缀和
        int curr = 0;
        for (int i = 1; i <= 50; ++i) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0) {
                return false;
            }
        }
        return true;
    }

}
