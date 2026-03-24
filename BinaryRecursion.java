public class BinaryRecursion {
    private static long iterationCount = 0;

    public static void resetCount() {
        iterationCount = 0;
    }

    public static long getIterationCount() {
        return iterationCount;
    }

    /**
     * Recursive Binary Search — returns index of target, or -1 if not found.
     * Array must be sorted before calling.
     */
    public static int search(int[] arr, int target) {
        return binarySearch(arr, 0, arr.length - 1, target);
    }

    private static int binarySearch(int[] arr, int left, int right, int target) {
        iterationCount++;
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) return binarySearch(arr, mid + 1, right, target);
        else return binarySearch(arr, left, mid - 1, target);
    }

    /**
     * Recursive sum of array — demonstrates linear recursion.
     */
    public static long recursiveSum(int[] arr, int n) {
        iterationCount++;
        if (n <= 0) return 0;
        return arr[n - 1] + recursiveSum(arr, n - 1);
    }

    public static String getComplexity() {
        return "Time: O(log n) | Space: O(log n) call stack [Master Thm: T(n) = T(n/2) + O(1) => O(log n)]";
    }
}
