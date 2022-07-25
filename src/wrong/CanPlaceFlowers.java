package wrong;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] param = new int[]{1, 0, 0, 0, 1};
        boolean result = canPlaceFlowers(param, 2);
        System.out.println(result);
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
