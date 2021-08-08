/**
 * @author taojie
 */
// 定义状态：f(x)是当x=index时，...
// 定义状态转义方程：f(x) = ...
// 定义初始值：f(0) = ...
public class Template {

    public static void main(String[] args) {
        int param = 1;
        int result = doTest(param);
        System.out.println(result);
    }

    public static int doTest(int param) {
        return 1;
    }

    // 全局变量，记录递归函数的递归层数
    public static int count = 1;

    // 在递归函数的开头，调用 printIndent(count++) 并打印关键变量；然后在所有 return 语句之前调用 printIndent(--count) 并打印返回值。
    // 递归函数的开头：printIndent(count++); System.out.println("i = %d, j = %d\n", i, j);
    // 递归函数的结尾：printIndent(--count); System.out.println("return %d\n", res);
    public static void printRecursion(String data, boolean flag) {
        if (!flag) {
            count--;
        }
        String s = "层出参：";
        if (flag) {
            s = "层入参：";
        }
        System.out.println(getBlank(count) + "第" + count + s + data);
        if (flag) {
            count++;
        }
    }

    public static String getBlank(int n) {
        String s = "";
        if (n == 1) {
        } else if (n == 2) {
            s = "   ";
        } else if (n == 3) {
            s = "       ";
        } else if (n == 4) {
            s = "           ";
        } else if (n == 5) {
            s = "               ";
        } else if (n == 6) {
            s = "                   ";
        } else if (n == 7) {
            s = "                       ";
        } else if (n == 8) {
            s = "                           ";
        } else if (n == 9) {
            s = "                               ";
        } else if (n == 10) {
            s = "                                   ";
        }
        return s;
    }

}
