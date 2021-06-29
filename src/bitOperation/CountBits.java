package bitOperation;

public class CountBits {

    public static void main(String[] args) {
        int param = 8;
        int[] result = countBits(param);
        System.out.println(result);
    }

    // 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
    // num = 2;
    public static int[] doTest(int num) {

        return null;
    }

    public static int[] doCountBits(int param) {
        int[] result = new int[param + 1];
        for (int i = 0; i<=param; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    public static int countOnes(int x) {
        int oneCount = 0;
        while (x > 0) {
            x = x&(x-1);
            oneCount++;
        }
        return oneCount;
    }

    // 动态规划，官方解法
    public static int[] countBits(int num) {
        /*int[] bits = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;*/

        int[] bits = new int[num + 1];
        bits[0] = 0;
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }

}
