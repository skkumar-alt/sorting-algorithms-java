import java.util.Arrays;
import java.util.Random;

public class MainFile {

    // ─────────────────────────────────────────────
    //  Utility helpers
    // ─────────────────────────────────────────────

    static int[] generateRandom(int size, int bound) {
        Random rng = new Random(42);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rng.nextInt(bound);
        return arr;
    }

    static void printArray(int[] arr, int maxShow) {
        if (arr.length <= maxShow) {
            System.out.println("  " + Arrays.toString(arr));
        } else {
            int[] head = Arrays.copyOfRange(arr, 0, maxShow / 2);
            int[] tail = Arrays.copyOfRange(arr, arr.length - maxShow / 2, arr.length);
            System.out.println("  " + Arrays.toString(head) + " ... " + Arrays.toString(tail));
        }
    }

    static void printDivider() {
        System.out.println("═".repeat(75));
    }

    static void printSubDivider() {
        System.out.println("─".repeat(75));
    }

    // ─────────────────────────────────────────────
    //  Test runners
    // ─────────────────────────────────────────────

    static void testSortingAlgorithm(String name, int[] input, int[] result,
                                     long iterations, long timeNs, String complexity) {
        boolean correct = isSorted(result);
        System.out.printf("%n  Algorithm   : %s%n", name);
        System.out.printf("  Input size  : %d elements%n", input.length);
        System.out.print("  Input       : ");  printArray(input, 10);
        System.out.print("  Output      : ");  printArray(result, 10);
        System.out.printf("  Sorted?     : %s%n", correct ? "✔ YES" : "✘ NO");
        System.out.printf("  Iterations  : %,d%n", iterations);
        System.out.printf("  Time taken  : %.4f ms  (%,d ns)%n", timeNs / 1_000_000.0, timeNs);
        System.out.printf("  Complexity  : %s%n", complexity);
        printSubDivider();
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1]) return false;
        return true;
    }

    // ─────────────────────────────────────────────
    //  Main
    // ─────────────────────────────────────────────

    public static void main(String[] args) {

        // ── Data sets ──────────────────────────────
        int[][] sizes = { {10, 100}, {100, 1000}, {1000, 10000} };
        // For O(n²) algos we cap at 1000 elements to keep output readable

        printDivider();
        System.out.println("   DSA / CP  —  Sorting Algorithm Benchmark");
        System.out.println("   Master's Theorem & Akra-Bazzi Complexity Verification");
        printDivider();

        // ══════════════════════════════════════════
        //  1. MERGE SORT
        // ══════════════════════════════════════════
        System.out.println("\n█  MERGE SORT");
        for (int[] sd : sizes) {
            int size = sd[0]; int bound = sd[1];
            int[] input = generateRandom(size, bound);
            int[] data  = input.clone();
            MergeSort.resetCount();
            long t0 = System.nanoTime();
            MergeSort.sort(data);
            long t1 = System.nanoTime();
            testSortingAlgorithm("Merge Sort", input, data, MergeSort.getIterationCount(), t1-t0, MergeSort.getComplexity());
        }

        // ══════════════════════════════════════════
        //  2. QUICK SORT
        // ══════════════════════════════════════════
        System.out.println("\n█  QUICK SORT");
        for (int[] sd : sizes) {
            int size = sd[0]; int bound = sd[1];
            int[] input = generateRandom(size, bound);
            int[] data  = input.clone();
            QuickSort.resetCount();
            long t0 = System.nanoTime();
            QuickSort.sort(data);
            long t1 = System.nanoTime();
            testSortingAlgorithm("Quick Sort", input, data, QuickSort.getIterationCount(), t1-t0, QuickSort.getComplexity());
        }

        // ══════════════════════════════════════════
        //  3. HEAP SORT
        // ══════════════════════════════════════════
        System.out.println("\n█  HEAP SORT");
        for (int[] sd : sizes) {
            int size = sd[0]; int bound = sd[1];
            int[] input = generateRandom(size, bound);
            int[] data  = input.clone();
            HeapSort.resetCount();
            long t0 = System.nanoTime();
            HeapSort.sort(data);
            long t1 = System.nanoTime();
            testSortingAlgorithm("Heap Sort", input, data, HeapSort.getIterationCount(), t1-t0, HeapSort.getComplexity());
        }

        // ══════════════════════════════════════════
        //  4. BUBBLE SORT  (cap at 1000)
        // ══════════════════════════════════════════
        System.out.println("\n█  BUBBLE SORT  [O(n²) — capped at n=1000]");
        for (int[] sd : sizes) {
            int size = sd[0]; int bound = sd[1];
            int[] input = generateRandom(size, bound);
            int[] data  = input.clone();
            BubbleSort.resetCount();
            long t0 = System.nanoTime();
            BubbleSort.sort(data);
            long t1 = System.nanoTime();
            testSortingAlgorithm("Bubble Sort", input, data, BubbleSort.getIterationCount(), t1-t0, BubbleSort.getComplexity());
        }

        // ══════════════════════════════════════════
        //  5. INSERTION SORT  (cap at 1000)
        // ══════════════════════════════════════════
        System.out.println("\n█  INSERTION SORT  [O(n²) — capped at n=1000]");
        for (int[] sd : sizes) {
            int size = sd[0]; int bound = sd[1];
            int[] input = generateRandom(size, bound);
            int[] data  = input.clone();
            InsertionSort.resetCount();
            long t0 = System.nanoTime();
            InsertionSort.sort(data);
            long t1 = System.nanoTime();
            testSortingAlgorithm("Insertion Sort", input, data, InsertionSort.getIterationCount(), t1-t0, InsertionSort.getComplexity());
        }

        // ══════════════════════════════════════════
        //  6. SELECTION SORT  (cap at 1000)
        // ══════════════════════════════════════════
        System.out.println("\n█  SELECTION SORT  [O(n²) — capped at n=1000]");
        for (int[] sd : sizes) {
            int size = sd[0]; int bound = sd[1];
            int[] input = generateRandom(size, bound);
            int[] data  = input.clone();
            SelectionSort.resetCount();
            long t0 = System.nanoTime();
            SelectionSort.sort(data);
            long t1 = System.nanoTime();
            testSortingAlgorithm("Selection Sort", input, data, SelectionSort.getIterationCount(), t1-t0, SelectionSort.getComplexity());
        }

        // ══════════════════════════════════════════
        //  7. BINARY RECURSION (Binary Search)
        // ══════════════════════════════════════════
        System.out.println("\n█  BINARY RECURSION (Binary Search)");
        int[] sortedArr = generateRandom(1000, 10000);
        Arrays.sort(sortedArr);

        int[] targets = { sortedArr[0], sortedArr[499], sortedArr[999], -1 };
        String[] tLabels = { "first element", "middle element", "last element", "missing (-1)" };

        for (int t = 0; t < targets.length; t++) {
            BinaryRecursion.resetCount();
            long t0 = System.nanoTime();
            int idx = BinaryRecursion.search(sortedArr, targets[t]);
            long t1 = System.nanoTime();
            System.out.printf("%n  Algorithm   : Binary Recursive Search (%s)%n", tLabels[t]);
            System.out.printf("  Array size  : %d (sorted)%n", sortedArr.length);
            System.out.printf("  Target      : %d%n", targets[t]);
            System.out.printf("  Found at    : %s%n", idx >= 0 ? "index " + idx : "Not found");
            System.out.printf("  Iterations  : %,d%n", BinaryRecursion.getIterationCount());
            System.out.printf("  Time taken  : %.4f ms  (%,d ns)%n", (t1-t0)/1_000_000.0, t1-t0);
            System.out.printf("  Complexity  : %s%n", BinaryRecursion.getComplexity());
            printSubDivider();
        }

        // ══════════════════════════════════════════
        //  SUMMARY TABLE
        // ══════════════════════════════════════════
        printDivider();
        System.out.println("\n  COMPLEXITY SUMMARY (Master's / Akra-Bazzi Theorem)\n");
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Algorithm", "Recurrence", "Time", "Space");
        System.out.println("  " + "─".repeat(68));
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Merge Sort",      "T(n)=2T(n/2)+O(n)", "O(n log n)", "O(n)");
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Quick Sort",      "T(n)=2T(n/2)+O(n)", "O(n log n)*","O(log n)");
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Heap Sort",       "T(n)=T(n/2)+O(1)",  "O(n log n)", "O(1)");
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Bubble Sort",     "—  (iterative)",     "O(n²)",      "O(1)");
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Insertion Sort",  "—  (iterative)",     "O(n²)",      "O(1)");
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Selection Sort",  "—  (iterative)",     "O(n²)",      "O(1)");
        System.out.printf("  %-18s %-20s %-15s %-10s%n", "Binary Search",   "T(n)=T(n/2)+O(1)",  "O(log n)",   "O(log n)");
        System.out.println("\n  * Quick Sort: O(n log n) average, O(n²) worst case");
        System.out.println("\n  Master's Theorem applied where T(n) = aT(n/b) + f(n):");
        System.out.println("  ┌─ Merge/Quick : a=2, b=2, f(n)=n  → log_b(a)=1 = deg(f) → Case 2 → O(n log n)");
        System.out.println("  ├─ Heap(ify)   : a=1, b=2, f(n)=1  → log_b(a)=0 = deg(f) → Case 2 → O(log n)");
        System.out.println("  └─ BinarySearch: a=1, b=2, f(n)=1  → log_b(a)=0 = deg(f) → Case 2 → O(log n)");
        printDivider();
    }
}
