package wrong;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] param = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(param);
        System.out.println(result);
    }

    public static List<Integer> doTest(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (list.contains(num)) {
                list.remove(list.indexOf(num));
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

}
