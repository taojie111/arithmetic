import linked.commom.ListNode;
import tree.common.TreeNode;

import java.util.*;

public class Test {

    public static void main(String[] args) {
       minWindow("ADOBECODEBANC", "ABC");
    }

    static class User {
        public String name;
        public String sex;

        public User(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public boolean equals(Object obj) {
            User u = (User) obj;
            return this.getName().equals(u.getName());
        }
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

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static Map<Character, Integer> ori = new HashMap<Character, Integer>();
    static Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public static String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public static boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public static int minDepth(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valueQueue.offer(root.getValue());
        int result = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer value = valueQueue.poll();
            result++;
            if (node.getLeft() == null && node.getRight() == null) {
                return result;
            }
            if (node.getLeft() != null) {
                nodeQueue.offer(node.getLeft());
                valueQueue.offer(node.getLeft().getValue());
            }

            if (node.getRight() != null) {
                nodeQueue.offer(node.getRight());
                valueQueue.offer(node.getRight().getValue());
            }
        }
        return result;
    }

    static List<List<Integer>> res = new LinkedList<>();


    static List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    static void backtrack(int[] nums, LinkedList<Integer> track) {

        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}
