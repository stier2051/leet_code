package algorithms.sorting;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
//        int[] array = new int[]{34, 12, 54, 10, 9, 0, 76, 1, 23, 44};
//        Sort selectionSort = new SelectionSort();
//        System.out.println(Arrays.toString(selectionSort.sort(array)));
//        int[] array1 = new int[]{35, 12, 54, 10, 9, 0, 76, 1, 23, 44};
//        measureTime(array1);
//        int[] array2 = new int[]{0, 1, 54, 65, 67, 78, 79, 80, 96, 99};
//        measureTime(array2);
//        int[] array3 = new int[]{35, 12, 54, 10, 9, 0, 76, 1, 23, 44};
//        Sort insertionSort = new InsertionSort();
//        System.out.println(Arrays.toString(insertionSort.sort(array3)));
//        int[] array4 = new int[]{9,15,0,0,12,34,54,8,1,9,27,54,34,19};
//        Sort countingSort = new CountingSort();
//        System.out.println(Arrays.toString(countingSort.sort(array4)));
//        int[] array5 = new int[]{9,15,5,5,12,34,54,8,9,27,54,34,19};
//        System.out.println(Arrays.toString(countingSort.sort(array5)));

//        Sort mergeSort = new MergeSort();
//        int[] array6 = new int[]{9,15,5,5,12,10,54,8,9,27,54,34,19};
//        System.out.println(Arrays.toString(mergeSort.sort(array6)));

        Sort quickSort = new QuickSort();
        int[] array6 = new int[]{9,15,5,5,12,10,54,8,9,27,54,34,19};
        System.out.println(Arrays.toString(quickSort.sort(array6)));

    }

    private static void measureTime(int[] nums) {
        long start = System.currentTimeMillis();

        Sort bubbleSort = new SelectionSort();
        bubbleSort.sort(nums);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
