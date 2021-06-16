package greed;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] param = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 0};
        boolean result = canPlaceFlowers(param, 2);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：能全部种植下所有的花
    // 2、局部最优解：每朵花都能种植下
    // 3、合并局部解
    public static boolean doTest(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int i = 0;
        int front;
        int after;
        while (i < length) {
            if (flowerbed[i] == 0) {
                if (i == 0) {
                    front = 0;
                } else {
                    front = flowerbed[i - 1];
                }
                if (i == length - 1) {
                    after = 0;
                } else {
                    after = flowerbed[i + 1];
                }
                if (front == 0 && after == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (n == 0) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }

}