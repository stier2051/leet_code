/**
 * Given an integer array nums, return true if any value appears at
 * least twice in the array, and return false if every element is distinct.

 * Constraints:

 *     1 <= nums.length <= 10^5
 *     -10^9 <= nums[i] <= 10^9
 */

package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(containsDuplicate(nums));
        System.out.println(Math.pow(2, 3));
    }
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length > Math.pow(10, 5)) {
            System.out.println("Error: 1 <= nums.length <= 10^5");
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
