package primary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {

    public static void main(String[] args) {
        int[] param1 = new int[]{4,9,5};
        int[] param2 = new int[]{9,4,9,8,4};
        int[] result = doTest2(param1, param2);
        System.out.println(result);
    }

    public static int[] doTest(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    nums1[i] = Integer.MAX_VALUE;
                    nums2[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] doTest2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
