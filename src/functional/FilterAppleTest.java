package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterAppleTest {

    static List<Apple> apples = Arrays.asList(
            new Apple("red", 150),
            new Apple("green", 200),
            new Apple("green", 130)
    );
    public static void main(String[] args) {
        //use methods
        System.out.println(filterApples(apples, Apple::isGreenApple));
        System.out.println(filterApples(apples, Apple::isHeavyApple));

        //as lambda without using method (isGreenApple, isHeavyApple)
        filterApples(apples, (Apple a) -> "green".equals(a.getColor()));
        filterApples(apples, (Apple a) -> a.getWeight() > 150);


    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesWithApplePredicate(List<Apple> apples, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
