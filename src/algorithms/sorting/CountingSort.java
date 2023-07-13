package algorithms.sorting;

public class CountingSort implements Sort {

    @Override
    public int[] sort(int[] nums) {
        int max = 0;
        int min = 0;
        for (int num : nums) {
            if (num > max) {max = num;}
            if (num < min) {min = num;}
        }

        int[] array = new int[max - min + 1];
        for (int num : nums) {
            array[num - min]++;
        }

        int arrIndex = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                nums[arrIndex] = i + min;
                arrIndex++;
            }
        }

        return nums;
    }
}
