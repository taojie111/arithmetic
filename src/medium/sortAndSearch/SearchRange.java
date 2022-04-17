package medium.sortAndSearch;

public class SearchRange {
    public static void main(String[] args) {
        int[] param = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = doTest2(param, 8);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums, int target) {
        int first = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == target) {
                first = first == -1 ? i : first;
                end = i;
            }
        }
        return new int[]{first, end};
    }

    public static int[] doTest2(int[] nums, int target) {
        int standard = binarySearch(nums, target);
        if (standard == -1) {
            return new int[]{-1, -1};
        }
        int first = standard;
        int end = standard;
        while (first > 0) {
            first--;
            if (nums[first] != nums[standard]) {
                first++;
                break;
            }
        }
        while (end < nums.length - 1) {
            end++;
            if (nums[end] != nums[standard]) {
                end--;
                break;
            }
        }
        return new int[]{first, end};
    }

    public static int binarySearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
