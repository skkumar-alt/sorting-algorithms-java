public class BubbleSort {
    private static long iterationCount = 0;

    public static void resetCount() {
        iterationCount = 0;
    }

    public static long getIterationCount() {
        return iterationCount;
    }

    public static int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                iterationCount++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return arr;
    }

    public static String getComplexity() {
        return "Time: O(n²) avg/worst, O(n) best | Space: O(1) [No recurrence — nested loops]";
    }
}
