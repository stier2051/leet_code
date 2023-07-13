package algorithms.sorting;

public class BubbleSort implements Sort{
    @Override
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                return nums;
            }
        }
        return nums;
    }
}
