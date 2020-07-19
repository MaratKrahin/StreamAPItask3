package StreamAPITask3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<String> names = Arrays.asList("Иванов", "Петров", "Сидоров");
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 12_000_000; i++) {
            peoples.add(new People(names.get(
                    new Random().nextInt(names.size())),
                    new Random().nextInt(100),
                    Sex.randomSex()));
        }

        long count =  peoples.stream()
                .filter(it -> it.getSex().equals(Sex.MAN))
                .filter(it -> it.getAge() > 18 && it.getAge() < 27)
                .count();

        System.out.println("кол-во военнообязаных мужчин: " + count);

        long stopTime = System.nanoTime();
        double processTime = (double) (stopTime - startTime) / 1_000_000_000.0;
        System.out.println("Process time: " + processTime + " s");

        // на Stream выполняется Process time: 10.314011974 s
        // на parallelStream() Process time: 9.947483262 s
    }
}
