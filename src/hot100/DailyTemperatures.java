package hot100;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] param = new int[]{73,74,75,71,69,72,76,73};
        int[] result = doTest(param);
        System.out.println(result);
    }

    public static int[] doTest(int[] arr) {
        int[] result = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                count++;
                if (arr[j] > arr[i]) {
                    result[i] = count;
                    count = 0;
                    break;
                }
            }

        }
        return result;
    }

    public static int[] doTest2(int[] arr) {
        int[] result = new int[arr.length];


        return result;
    }
}
