package primary.sortAndSearch;

public class FirstBadVersion {

    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isBadVersion(int n) {
        return true;
    }
}
