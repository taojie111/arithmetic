package prefixSum;

public class SumOddLengthSubarrays {

    public static void main(String[] args) {
        int[] param = new int[]{1,4,2,5,3};
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int[] arr) {
        int n = arr.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSums[end + 1] - prefixSums[start];
            }
        }
        return sum;
    }

    public static boolean isOdd(int number) {
        if (number % 2 == 0) {
            return false;
        }
        return true;
    }
}
