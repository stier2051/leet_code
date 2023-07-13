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

        for (int i = n; i < nums.length - n;) {
            right[i] = nums[i];
        }

        System.arraycopy(nums, 0, left, 0, left.length);
        System.arraycopy(nums, nums.length - nums.length / 2, right, nums.length - nums.length / 2, right.length);

        return new int[0];
    }

    public int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
//        for (int i = 0; i < )
        return null;
    }
}
