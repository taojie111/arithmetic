package hot100;

/**
 * @author taojie
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] param = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = doTest2(param);
        System.out.println(result);
    }

    public static int doTest(int[] height) {
        int length = height.length;
        int maxArea = 0;
        for (int x1 = 0; x1 < length; x1++) {
            for (int x2 = x1 + 1; x2 < length; x2++) {
                int area = (x2 - x1) * Math.min(height[x1], height[x2]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static int doTest2(int[] height) {
        int maxArea = 0;
        int len = height.length;
        int p1 = 0;
        int p2 = len-1;
        while (p1 < p2) {
            int area = (p2 - p1) * Math.min(height[p1], height[p2]);
            maxArea = Math.max(maxArea, area);
            if (height[p1] <= height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        return maxArea;
    }
}
