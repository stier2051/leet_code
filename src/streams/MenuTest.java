package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Dish> dishes = specialMenu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());

        List<Dish> dishes2 = specialMenu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());

        List<Dish> meatDish = specialMenu
                .stream()
                .filter(dish -> dish.getType() == Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());

        List<String> dishNames = specialMenu
                .stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());


    }
}
