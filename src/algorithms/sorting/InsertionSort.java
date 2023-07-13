package algorithms.sorting;

public class InsertionSort implements Sort{
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1 + i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        return nums;
    }
}
