package bitOperation;

// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
// 示例 1:输入: [2,2,1],输出: 1
// 示例 2:输入: [4,1,2,1,2],输出: 4
public class SingleNumber {

    public static void main(String[] args) {
        int[] param = new int[]{4,1,2,1,2};
        int result = doSingleNumber(param);
        System.out.println(result);
    }

    public static int doSingleNumber(int[] param) {
        int result = 0;
        for (int num : param) {
            result ^= num;
        }
        return result;
    }
}
