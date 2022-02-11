package primary.array;

public class SingleNumber {

    public static void main(String[] args) {
        int[] param = new int[]{4,1,2,1,2};
        int result = doSingleNumber(param);
        System.out.println(result);
    }

    public static int doSingleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
