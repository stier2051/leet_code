package streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MenuTest {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER)
        );

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        //limit
        List<Dish> limitDishes = specialMenu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());

        limitDishes.forEach(System.out::println);

        //skip
        List<Dish> skipDishes = specialMenu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        skipDishes.forEach(System.out::println);

        List<Dish> meatDish = specialMenu
                .stream()
                .filter(dish -> dish.getType() == Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());

        List<String> dishNames = specialMenu
                .stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        //takeWhile
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        slicedMenu1.forEach(System.out::println);

        //dropWhile
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        slicedMenu2.forEach(System.out::println);

        //use mapping
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());

        List<Integer> dishNameLengths = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        List<String> strings = Arrays.asList("Hello", "World");

        //use flatMap
        List<String> stream = strings.stream()
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        //возвращаем примитив int
        int calories = specialMenu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);

        //преобразование обратно в поток объектов
        IntStream intStream = specialMenu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream1 = intStream.boxed();

        //значения по умолчанию: класс OptionalInt
        OptionalInt maxCalories = specialMenu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max = maxCalories.orElse(1);

        //range - не включает границы диапазона в отличие от rangeClosed
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        //Пифагорова тройка
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                        );
        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }
}
