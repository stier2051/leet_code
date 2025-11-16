package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static streams.Type.*;

public class MenuTest {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("rice", true, 350, OTHER),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER),
                new Dish("pork", false, 800, MEAT),
                new Dish("beef", false, 700, MEAT),
                new Dish("pizza", true, 550, OTHER),
                new Dish("salmon", false, 450, FISH)
        );

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println(filteredMenu);

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
                .filter(dish -> dish.getType() == MEAT)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(meatDish);

        List<String> dishNames = specialMenu
                .stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(dishNames);

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
        System.out.println(wordLengths);

        List<Integer> dishNameLengths = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(dishNameLengths);

        List<String> strings = Arrays.asList("Hello", "World");

        //use flatMap
        List<String> stream = strings.stream()
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(stream);

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

        //Collectors methods
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = specialMenu.stream()
                .collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);

        int totalCalories = specialMenu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        IntSummaryStatistics menuStatistics = specialMenu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu = specialMenu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);
    }
}
