/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

 * Example 1:
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */

package easy;

import java.util.Arrays;

public class SmallerThenI {
    public static void main(String[] args) {
        int[] array = new int[]{6, 0, 1, 7, 8, 1};
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(selectionSort(array)));
    }

    public static int[] selectionSort(int[] nums) {

        int arraySize = nums.length;

        int[] arrayIndexesOrder = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrayIndexesOrder[i] = i;
        }

        for (int i = 0; i < arraySize; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arraySize; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            //swap indexes of array
            int tempIndex = arrayIndexesOrder[i];
            arrayIndexesOrder[i] = arrayIndexesOrder[minIndex];
            arrayIndexesOrder[minIndex] = tempIndex;

            //swap elements of array
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        int[] smallerNumbersCountArray = new int[arraySize];
        for (int i = arraySize - 1; i > 0; i--) {
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            smallerNumbersCountArray[arrayIndexesOrder[i]] = count;
        }

        //smallerNumbersCountArray
        //arrayOrder
        int[] outputArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            outputArray[arrayIndexesOrder[i]] = smallerNumbersCountArray[i];
        }

        return outputArray;

//Best Solution
//        int num, leng;
//        leng = nums.length;
//        int[] err ={0,0};
//        int[] combinations = new int[101];
//
//
//        if(leng > 500 || leng < 2){
//            System.out.println("Length should be between 2 and 500");
//            return err;
//        }
//
//        for(int i=0; i< leng; i++){
//            num = nums[i];
//            if(num<0 || num> 100){
//                System.out.println("number should be between 0 and 100");
//                return err;
//            }
//            combinations[num] += 1;
//        }
//
//
//        for (int i = 1; i < 100; i++) {
//            combinations[i] += combinations[i-1];
//        }
//
//        int[] ans = new int[leng];
//        for (int i = 0; i < leng; i++) {
//            if(nums[i] == 0){
//                ans[i] = 0;
//            }
//            else
//                ans[i] = combinations[nums[i]-1];
//
//        }
//
//        return ans;
    }

}
