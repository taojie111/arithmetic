package bitOperation;

// https://leetcode-cn.com/problems/number-complement/
public class FindComplement {

    public static void main(String[] args) {
        int mask = (5 << 1) - 1;
        int param = 5;
        int result = doFindComplement(param);
        System.out.println(result);
    }

    // 官方的解法
    public static int doFindComplement(int param) {
        // 解法1
        int tmp = param;
        int num2 = 1;
        while(tmp>0){
            num2<<=1;
            tmp>>=1;
        }
        num2-=1;
        return param^num2;

        // 解法2,把所有二进制位都变为1，再取反求&操作
        /*int n = param;
        while((n & (n - 1)) != 0){
            n = (n & (n - 1));
        }
        // 获得掩码，如101 的掩码就是000000...000111
        int mask = (n << 1) - 1;
        // 5取反之后就是 111111...1111010
        // 返回与掩码&的结果即可
        return (~param) & mask;*/
    }

}
