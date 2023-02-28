package easy;

public class RomanToInteger {
    public static void main(String[] args) {

    }

    public static int romanToInt(String s) {
        int i = 0;
        char[] liters = s.toCharArray();
        for (char x : liters) {
            switch (x) {
                case 'I':
                    x = 1;
                    break;
                case 'V':
                    x = 5;
                    break;
                case 'X':
                    x = 10;
                    break;
                case 'L':
                    x = 50;
                    break;
                case 'C':
                    x = 100;
                    break;
                case 'D':
                    x = 500;
                    break;
                case 'M':
                    x = 1000;
                    break;
                default:
                    break;
            }
        }
    }
}
