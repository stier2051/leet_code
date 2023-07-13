/**
 * Given an integer x, return true if x is a palindrome, and false otherwise.

 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 */

package easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int y = x;
            int z = x;
            int count = 0;
            int result = 0;

            while (y >= 10) {
                y = y / 10;
                count++;
            }

            for (int i = 0; i < count + 1; i++) {
                int mod = z % 10;
                z = z / 10;
                result += mod * (int)Math.pow(10, count - i);
            }
            return x == result;
        }
    }
}
