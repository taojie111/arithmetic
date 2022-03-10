package primary.other;

public class ReverseBits {

    public static void main(String[] args) {
        int result = reverseBits1(13);
        System.out.println(result);
    }

    public static int reverseBits1(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    // 01010101010101010101010101010101
    private static final int M1 = 0x55555555;
    // 00110011001100110011001100110011
    private static final int M2 = 0x33333333;
    // 00001111000011110000111100001111
    private static final int M4 = 0x0f0f0f0f;
    // 00000000111111110000000011111111
    private static final int M8 = 0x00ff00ff;

    public static int reverseBits2(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

}
