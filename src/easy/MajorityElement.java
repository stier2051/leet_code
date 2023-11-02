package easy;

public class MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        quickSort(nums, 0, nums.length);
        return 0;
    }

    public void quickSort(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int pivot = partition(arr, i, j); //[i, pivot-1] < pivot, [pivot+1, j] > pivot

        quickSort(arr, i, pivot);
        quickSort(arr, pivot+1, j);
    }

    private int partition(int[] arr, int i, int j) {
        int pivot = i;
        int s1Index = i;
        int s2Index = i;

        for (int k = i+1; k < j; k++) {
            if (arr[k] >= arr[pivot]) {
                s2Index++;
            } else {
                s1Index++;
                swap(arr, s1Index, k);
                s2Index++;
            }
        }
        swap(arr, pivot, s1Index);
        pivot = s1Index;
        return pivot;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
