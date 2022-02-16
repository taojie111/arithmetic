package primary.array;

public class IsAnagram {

    public static void main(String[] args) {
        boolean result = doTest("anagram", "nagaram");
        System.out.println(result);
    }

    public static boolean doTest(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result ^ s.charAt(i);
        }
        for (int i = 0; i <t.length();i++) {
            result = result ^ t.charAt(i);
        }
        return result == 0 ? true : false;
    }
}
