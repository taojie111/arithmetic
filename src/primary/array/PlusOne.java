package primary.array;

public class PlusOne {

    public static void main(String[] args) {
        int[] param = new int[]{9,9,9,9};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] digits) {
        int length = digits.length;
        int index = length - 1;
        int[] result = new int[length + 1];
        while (index >= 0) {
            if (digits[index] < 9) {
                digits[index] += 1;
                return digits;
            } else {
                digits[index] = 0;
                index--;
            }
        }
        return digits;
    }
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

}
