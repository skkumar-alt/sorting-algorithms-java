public class SelectionSort {
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
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                iterationCount++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
        }
        return arr;
    }

    public static String getComplexity() {
        return "Time: O(n²) all cases | Space: O(1) [No recurrence — nested loops, always n(n-1)/2 comparisons]";
    }
}
