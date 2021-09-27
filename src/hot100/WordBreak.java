package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
      /*  String s = "applepenapple";
        System.out.println(s.replace("apple4", "*****"));*/
        List<String> param = new ArrayList<>();
        /*param.add("cats");
        param.add("dog");
        param.add("sand");
        param.add("and");
        param.add("cat");*/

//        param.add("leetc");
        param.add("le");
        param.add("et");
        param.add("code");
        boolean result = wordBreak("leetcode",param);
        System.out.println(result);
    }

    public static boolean doTest(String s, List<String> wordDict) {
        for (String str : wordDict) {
            String replaceS = "";
            for (int i = 0; i < str.length(); i++) {
                replaceS = replaceS + "*";
            }
            s = s.replace(str, replaceS);
        }
        String replaceS = "";
        for (int i = 0; i < s.length(); i++) {
            replaceS = replaceS + "*";
        }
        return s.equals(replaceS);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                boolean jFlag = dp[j];
                boolean isContain = wordDictSet.contains(temp);
                if (jFlag && isContain) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
