public class InsertionSort {
    private static long iterationCount = 0;

    public static void resetCount() {
        iterationCount = 0;
    }

    public static long getIterationCount() {
        return iterationCount;
    }

    public static int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                iterationCount++;
                arr[j + 1] = arr[j];
                j--;
            }
            iterationCount++;
            arr[j + 1] = key;
        }
        return arr;
    }

    public static String getComplexity() {
        return "Time: O(n²) avg/worst, O(n) best | Space: O(1) [No recurrence — single loop with shifts]";
    }
}
