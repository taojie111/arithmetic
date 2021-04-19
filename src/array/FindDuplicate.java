package array;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] param = new int[]{1,3,2,3,4};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}
