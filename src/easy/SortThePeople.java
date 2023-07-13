/**
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 * Return names sorted in descending order by the people's heights.

 * Example 1:
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 * Explanation: Mary is the tallest, followed by Emma and John.

 * Example 2:
 * Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * Output: ["Bob","Alice","Bob"]
 * Explanation: The first Bob is the tallest, followed by Alice and the second Bob.

 * Constraints:
 *     n == names.length == heights.length
 *     1 <= n <= 103
 *     1 <= names[i].length <= 20
 *     1 <= heights[i] <= 10^5
 *     names[i] consists of lower and upper case English letters.
 *     All the values of heights are distinct.
 */

package easy;

import java.util.Arrays;

public class SortThePeople {

    public static void main(String[] args) {
//        String[] names = new String[]{"Alice", "Bruce", "John"};
//        int[] heights = new int[]{160, 175, 165};
//        System.out.println(Arrays.toString(sortPeople(names, heights)));

        String[] names1 = new String[]{"GXLVEHVABFOGSFXUYYR","TUHxnsxmu","X","OOYBLVKmzlaeaxbprc","ARNLAPtfvmutkfsa","XPMKPDUWOQEEILtbdjip","QICEutjbr","R"};
        int[] heights1 = new int[]{11578,89340,73785,12096,55734,89484,59775,72652};
        System.out.println(Arrays.toString(sortPeople(names1, heights1)));

        //11578,89340,73785,12096,55734,89484,59775,72652
        //(0,1,2,3,4,5,6,7)
        //i = 0; 89484,89340,73785,12096,55734,11578,59775,72652
        //(5,1,2,3,4,0,6,7)
        //i = 1; 89484,89340,73785,12096,55734,11578,59775,72652
        //(5,1,2,3,4,0,6,7)
        //i = 2; 89484,89340,73785,12096,55734,11578,59775,72652
        //(5,1,2,3,4,0,6,7)
        //i = 3; 89484,89340,73785,72652,55734,11578,59775,12096
        //(5,1,2,7,4,0,6,3)
        //i = 4; 89484,89340,73785,72652,59775,11578,55734,12096
        //(5,1,2,7,6,0,4,3)
        //i = 5; 89484,89340,73785,72652,59775,55734,11578,12096
        //(5,1,2,7,6,4,0,3)
        //i = 6; 89484,89340,73785,72652,59775,55734,12096, 11578
        //(5,1,2,7,6,4,3,0)

    }

    public static String[] sortPeople(String[] names, int[] heights) {
        String[] err = {"err"};
        if (names.length != heights.length) {
            System.out.println("n == names.length == heights.length");
            return err;
        }

        int length = heights.length;
        int[] heightsIndexOrder = new int[length];

        for (int i = 0; i < length; i++) {
            heightsIndexOrder[i] = i;
        }
        System.out.println(Arrays.toString(heightsIndexOrder));

        for (int i = 0; i < length; i++) {
            int maxIndex = i;
            for (int j = i+1; j < length; j++) {
                if (heights[maxIndex] < heights[j]) {
                    maxIndex = j;
                }
            }

            int tempIndexOrder = heightsIndexOrder[i];
            heightsIndexOrder[i] = heightsIndexOrder[maxIndex];
            heightsIndexOrder[maxIndex] = tempIndexOrder;

            int temp = heights[i];
            heights[i] = heights[maxIndex];
            heights[maxIndex] = temp;
        }

        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            if (names[heightsIndexOrder[i]].length() > 0 && names[heightsIndexOrder[i]].length() < 21 ) {
                result[i] = names[heightsIndexOrder[i]];
            } else {
                System.out.println("1 <= names[i].length <= 20");
                return err;
            }

        }
        return result;
    }
}
