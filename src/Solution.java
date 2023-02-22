import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solution {
    public static void main(String[] args) {
        System.out.println("Hi master!");

        System.out.println("----- Задание 1 -----\n");

        Stream<String> someWords = Stream.of("Слово", "Строка", "Какой то текст", "Еще текст", "ох");

        BiConsumer<String, String> biConsumer = (min, max) -> System.out.println(min + " <-> " + max);
        Comparator<String> personComparator = Comparator.comparing(String::length);
        findMinMax(someWords, personComparator, biConsumer);

        System.out.println("\n----- Задание 2 -----\n");

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(randomIntNumber(0,100));
        }
        System.out.println(integerList);
        amountOfEvenNumbers(integerList);

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));

        }
    }

    public static void amountOfEvenNumbers(List<Integer> list) {
        Stream<Integer> integerStream = list.stream();
        Predicate<Integer> integerPredicate = integer -> (integer % 2) == 0;
        Stream<Integer> result = integerStream.filter(integerPredicate);
        System.out.println("Кол-во четных чисел: " + result.count());

    }

    public static int randomIntNumber(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}