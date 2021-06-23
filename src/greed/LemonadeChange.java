package greed;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] param = new int[]{5,5,5,5,10,20,10};
        boolean result = doTest(param);
        System.out.println(result);
    }

    // 贪心算法
    // 1、全局最优解：所有顾客都能正确找零
    // 2、局部最优解：每位顾客能正确找零（找零大于5元，优先找10元）
    // 3、合并局部解
    public static boolean doTest(int[] bills) {
        int length = bills.length;
        for (int i = 0; i < length; i++) {
            if (i == 0 && bills[i] > 5) {
                return false;
            }
            // 找零大于5元，优先找10元
            if (bills[i] - 5 == 15) {
                // 查找0 ~ i - 1是否有10元面值
                int tenP = searchTen(bills, i);
                if (tenP != Integer.MAX_VALUE) {
                    // 查找0 ~ i - 1是否有5元面值
                    int fiveP = searchFive(bills, i);
                    if (fiveP != Integer.MAX_VALUE) {
                        // 可以找零，把相应的位置替换位0
                        bills[tenP] = 0;
                        bills[fiveP] = 0;
                    } else {
                        // 不能找零
                        return false;
                    }
                } else {
                    // 查找0 ~ i - 1是否有5元面值
                    int fiveP1 = searchFive(bills, i);
                    int fiveP2 = searchFive(bills, i);
                    int fiveP3 = searchFive(bills, i);
                    if (fiveP1 == Integer.MAX_VALUE || fiveP2 == Integer.MAX_VALUE || fiveP3 == Integer.MAX_VALUE) {
                        // 不能找零
                        return false;
                    } else {
                        // 可以找零，把相应的位置替换为0
                        bills[fiveP1] = 0;
                        bills[fiveP2] = 0;
                        bills[fiveP3] = 0;
                    }
                }
            } else if (bills[i] - 5 == 5) {
                int fiveP = searchFive(bills, i);
                if (fiveP != Integer.MAX_VALUE) {
                    // 可以找零，把相应的位置替换位0
                    bills[fiveP] = 0;
                } else {
                    // 不能找零
                    return false;
                }
            } else {
                continue;
            }
        }
        return true;
    }

    private static int searchTen(int[] bills, int end) {
        for (int i = 0; i < end; i++) {
            if (bills[i] == 10) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int searchFive(int[] bills, int end) {
        for (int i = 0; i < end; i++) {
            if (bills[i] == 5) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean lemonadeChange2(int[] bills) {
        int ten = 0;
        int five = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (ten == 0 && five >=3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
