package easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            nums1 = nums2;
            System.out.println(Arrays.toString(nums1));
            return;
        }

        if (n == 0) {
            System.out.println(Arrays.toString(nums1));
            return;
        };

        int leftIndex = m - 1;
        int rightIndex = n - 1;
        int index = m + n - 1;

        while (leftIndex >= 0 && rightIndex >= 0) {
            if (nums1[leftIndex] >= nums2[rightIndex]) {
                nums1[index] = nums1[leftIndex--];
            } else {
                nums1[index] = nums2[rightIndex--];
            }
            index--;
        }

        if (rightIndex != 0) {
            while (rightIndex >= 0) {
                nums1[rightIndex] = nums2[rightIndex--];
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
}
