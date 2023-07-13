/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Constraints:
 *     1 <= strs.length <= 200
 *     0 <= strs[i].length <= 200
 *     strs[i] consists of only lowercase English letters.
 */
package easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        //sort strings
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (strs[j].length() < strs[j-1].length()) {
                    String temp = strs[j];
                    strs[j] = strs[j-1];
                    strs[j-1] = temp;
                }
            }
        }

        String longestPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String temp = "";
            for (int j = longestPrefix.length(); j >= 1; j--) {
                if (longestPrefix.substring(0, j).equals(strs[i].substring(0, j))) {
                    temp = strs[0].substring(0, j);
                    break;
                }
            }
            longestPrefix = temp;
        }
        return longestPrefix;
    }
}
