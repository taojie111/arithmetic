package bitOperation;

// 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
// 输入：nums = [3,0,1],输出：2,解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
public class MissingNumber {

    public static void main(String[] args) {
        int[] param = new int[]{3,0,1};
        int result = doMissingNumber(param);
        System.out.println(result);
    }

    // 官方的位运算算法
    public static int doMissingNumber(int[] param) {
        int n = param.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result = result ^ i ^ param[i];
        }
        return result;
    }

}
