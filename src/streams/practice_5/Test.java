package streams.practice_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Trader> traders = new ArrayList<>();
        traders.add(raoul);
        traders.add(mario);
        traders.add(alan);
        traders.add(brian);

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)
        List<Transaction> transactions2011 = transactions
                .stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());

        transactions2011.forEach(System.out::println);

        //Вывести список неповторяющихся городов, в которых работают трейдеры
        List<String> traderCities = traders
                .stream()
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

        traderCities.forEach(System.out::println);

        //Найти всех трейдеров из Кембриджа и отсортировать их по именам
        List<Trader> tradersCambridge = transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());

        tradersCambridge.forEach(System.out::println);

        //Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке
        List<String> traderNames = traders
                .stream()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.toList());

        traderNames.forEach(System.out::println);

        //Выяснить, существует ли хоть один трейдер из Милана
        Boolean milanTrader = traders
                .stream()
                .anyMatch(e -> e.getCity().equals("Milan"));
        System.out.println(milanTrader);

        //Вывести сумму всех транзакций трейдеров из Кембриджа
        int transactionSum = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);

        System.out.println(transactionSum);

        //Какова максимальная сумма среди всех транзакций?
        int transactionMax = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);

        System.out.println(transactionMax);

        //Найти транзакцию с минимальной суммой
        int transactionMin = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::min);

        System.out.println(transactionMin);
    }
}
