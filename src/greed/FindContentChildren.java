package greed;

import java.util.Arrays;

/**
 * @author taojie
 */
public class FindContentChildren {

    public static void main(String[] args) {
        int[] param1 = new int[]{1,2,3};
        int[] param2 = new int[]{1,1};
        int result = findContentChildren(param1, param2);
        System.out.println(result);
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;
        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                count++;
            }
        }
        return count;
    }

}
