public class Test {

    public static void main(String[] args) {
        String s = "技术研发部(123456)";
        int i = s.indexOf('(');
        System.out.println(s.substring(i+1, s.length()-1));
    }

    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    public static int bf(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        // 主串的位置
        int i = 0;
        // 模式串的位置
        int j = 0;
        while (i < t.length && j < p.length) {
            // 当两个字符相同，就比较下一个
            if (t[i] == p[j]) {
                i++;
                j++;
            } else {
                // 一旦不匹配，i后退
                i = i - j + 1;
                // j归0
                j = 0;
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    // 计算n的阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n*factorial(n-1);
    }

    // 斐波那契数列的是这样一个数列：1、1、2、3、5、8、13、21、34、….，即第一项 f(1) = 1、第二项 f(2) = 1、…..、第 n 项目为 f(n)=f(n-1)+f(n-2)，求第 n 项的值是多少。
    // 1、明确函数功能：求数列第n项的值
    // 2、明确递归结束条件
    // 3、找出函数的等价关系式
    public static int Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n - 2);
    }
}
