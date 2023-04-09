/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000

 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 *     I can be placed before V (5) and X (10) to make 4 and 9.
 *     X can be placed before L (50) and C (100) to make 40 and 90.
 *     C can be placed before D (500) and M (1000) to make 400 and 900.

 * Given a roman numeral, convert it to an integer.
 */

package easy;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("XI"));
        System.out.println(romanToInt("XX"));
        System.out.println(romanToInt("V"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        int[] array = new int[s.length()];
        if (s.length() >= 1 && s.length() <= 15) {
            char[] liters = s.toCharArray();
            for (int i = 0; i < liters.length; i++) {
                switch (liters[i]) {
                    case 'I':
                        array[i] = 1;
                        break;
                    case 'V':
                        array[i] = 5;
                        break;
                    case 'X':
                        array[i] = 10;
                        break;
                    case 'L':
                        array[i] = 50;
                        break;
                    case 'C':
                        array[i] = 100;
                        break;
                    case 'D':
                        array[i] = 500;
                        break;
                    case 'M':
                        array[i] = 1000;
                        break;
                    default:
                        break;
                }
            }

            if (array.length == 1) {
                result = array[0];
            }
            if (s.length() > 1 && s.length() <= 15) {
                for (int j = 0; j < array.length; j++) {
                    if (j < array.length - 1 && array[j] < array[j + 1]) {
                        result += array[j + 1] - array[j];
                    } else if (j > 0 && array[j] > array[j - 1]) {
                        result += 0;
                    } else if (j < array.length - 1 && array[j] >= array[j + 1]) {
                        result += array[j];
                    } else if (j == array.length - 1 && array[j] <= array[j - 1]) {
                        result += array[j];
                    }
                }
            }
//Best Solution
//            for (int j = 0; j < array.length-1; j++) {
//                if (array[j] < array[j+1]) {
//                    result -= array[j];
//                } else {
//                    result += array[j];
//                }
//            }
//            result += array[array.length - 1];
        }
        return result;
    }
}
