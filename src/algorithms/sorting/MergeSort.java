package algorithms.sorting;

public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int n = nums.length / 2;
        int[] left = new int[n];
        int[] right = new int[nums.length - n];

        for (int i = 0; i < n; i++) {
            left[i] = nums[i];
        }

        for (int i = 0; i < nums.length - nums.length / 2; i++) {
            right[i] = nums[n++];
        }

        return merge(sort(left), sort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                merged[index] = left[leftIndex++];
                index++;
            } else {
                merged[index] = right[rightIndex++];
                index++;
            }
        }

        for (int i = leftIndex; i < left.length; i++) {
            merged[index++] = left[leftIndex++];
        }

        for (int i = rightIndex; i < right.length; i++) {
            merged[index++] = right[rightIndex++];
        }
        return merged;
    }
}
