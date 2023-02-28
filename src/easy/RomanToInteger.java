package easy;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int number = 0;
        char[] liters = s.toCharArray();
        int[] array = new int[liters.length];
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
        int result = 0;
        for (int j = 0; j < array.length; j++) {
            if (j < array.length - 1 && array[j] < array[j+1]) {
                result += array[j+1] - array[j];
            } else if (j > 0 && array[j] > array[j-1]) {
                result += 0;
            } else if (j < array.length - 1 && array[j] >= array[j+1]) {
                result += array[j];
            }
            System.out.println(array[j]);
        }
        return result;
    }
}
