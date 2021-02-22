package bitOperation;

public class HammingDistance {
    public static void main(String[] args) {
        int param1 = 6;
        int param2 = 4;
        int result = hammingDistance(param1,param2);
        System.out.println(result);
    }

    // java内置函数法
    public static int doHammingDistance(int param1, int param2) {
        return Integer.bitCount(param1 ^ param2);
    }

    // 官方的移位法
    public static int hammingDistanceWithMove(int param1, int param2) {
        int xor = param1 ^ param2;
        int result = 0;
        while (xor != 0) {
            if (xor % 2 == 1) {
                result++;
            }
            xor = xor >> 1;
        }
        return result;
    }

    // 官方解法（布赖恩·克尼根算法）
    public static int hammingDistance(int param1, int param2) {
        int xor = param1 ^ param2;
        int result = 0;
        while(xor != 0) {
            result++;
            xor = xor & (xor - 1);
        }
        return result;
    }
}
