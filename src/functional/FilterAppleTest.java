package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterAppleTest {

    static List<Apple> apples = Arrays.asList(
            new Apple("RED", 150),
            new Apple("GREEN", 200),
            new Apple("GREEN", 130)
    );
    public static void main(String[] args) {
        //use methods
        System.out.println(filterApples(apples, Apple::isGreenApple));
        System.out.println(filterApples(apples, Apple::isHeavyApple));

        //as lambda without using method (isGreenApple, isHeavyApple)
        filterApples(apples, (Apple a) -> Color.GREEN.name().equals(a.getColor()));
        filterApples(apples, (Apple a) -> a.getWeight() > 150);

        System.out.println(filterApplesWithApplePredicate(apples, new AppleGreenColorPredicate()));
        System.out.println(filterApplesWithApplePredicate(apples, new AppleHeavyWeightPredicate()));

        prettyPrintApple(apples, new AppleFancyFormater());
        prettyPrintApple(apples, new AppleSimpleFormatter());

        System.out.println(apples);
        changeObjects(apples, (Apple a) -> a.setColor(Color.GREEN.toString()));
        System.out.println(apples);

        List<Integer> l = map(Arrays.asList("hello", "lambda", "noutebook"), String::length);
        changeObjects(l, System.out::println);

        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);

        //sort apples by weight
        apples.sort(Comparator.comparing(Apple::getWeight));
        //sort apples by weight reversed
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        //sort by color after sorting by weight
        apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));


    }

    //Predicate
    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    //Supplier
    public static List<Apple> filterApplesWithApplePredicate(List<Apple> apples, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> apples, AppleFormatter f) {
        for (Apple apple : apples) {
            System.out.println(f.accept(apple));
        }
    }

    //Predicate
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    //Consumer
    public static <T> void changeObjects(List<T> list, Consumer<T> c) {
        for (T e : list) {
            c.accept(e);
        }
    }

    //Function
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }
}
