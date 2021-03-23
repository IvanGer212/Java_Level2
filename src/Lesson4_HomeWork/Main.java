package Lesson4_HomeWork;

import java.util.*;
import java.util.function.Consumer;
import java.math.*;
import java.util.function.Supplier;

import static java.util.Optional.empty;


public class Main {
    public static void main(String[] args) {
        /** 1. Создать коллекцию типа List. Наполнить ее значениями и вывести значения в консолько при помощи ее метода forEach.
            2. Создать утилитарный метод forItem. Метод принимает два параметра: Коллекция Set<String> и консьюмер типа Consumer<String>.
                Внутри метода проитерироваться по коллекции и для каждого элемента выполнить метод консьюмера accept, который выводит значение элемента в консоль.
            3. Создать утилитарный метод doubleUp. Метод принимает два параметра: значение типа int и консьюмер типа Supplier<Integer>.
                Внутри метода выполнить метод саплаера get, который возвращает множитель и затем переданное значение на него умножается.
                Фукнция возращает результат произведения.
            4. Создать метод findAllChars. Метод принимает два параметра: String target и char toFind. Первый параметр является входной строкой,
                а второй - символ, который необходимо найти в входящей строке. Учесть что искомый символ может повторяется (напр.: 'ccch').
                Необходимо найти все повторения и вернуть в виде конкатенированной строки обвернутый в Optional. Если ни одного совпадения не найдено,
                тогда необходимо вернуть пустой Optional. Пример выполнения: Optional<String> opt = findAllChars("ccch", 'c'); opt.get(); // вернет "ссс".
            5. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна. Однострочное текстовое поле
                для ввода сообщений и кнопка для отсылки сообщений на нижней панели. Сообщение должно отсылаться либо по нажатию кнопки на форме,
                либо по нажатию кнопки Enter. При «отсылке» сообщение перекидывается из нижнего поля в центральное. (ОПЦИОНАЛЬНО)
        */

        // Part 1
        System.out.println("Part 1");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add((int)(Math.random()*100));
        }
        numbers.forEach(num -> System.out.println(num));
        System.out.println();

        // Part 2
        System.out.println("Part 2");
        Set<String> words = new HashSet<>();
        words.add("hello");
        words.add("sun");
        words.add("cat");
        words.add("tank");
        words.add("fire");

        Consumer print = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };

        forItem(words,print);
        System.out.println();

        // Part 3
        System.out.println("Part 3");
        Supplier<Integer> multiplier = () -> {
            int multi = 4;
            System.out.println("Multi= " + multi);
            return multi;
            };

        System.out.println(doubleUp(15,multiplier));
        System.out.println();

        // Part 4
        System.out.println("Part 4");
        System.out.println(findAllChars("Fdfgfjf",'f').get());



    }

    static void forItem(Set<String> words,Consumer<String> print){
        words.forEach(word-> print.accept(word));
    }

    static double doubleUp (int number, Supplier<Integer> multiplier){
        return number*multiplier.get();
    }

    static Optional<String> findAllChars (String target, char toFind){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <target.length(); i++) {
            if (target.charAt(i) == toFind) {
                stringBuilder.append(toFind);
            }
        }
        if (stringBuilder.length() > 0){
        return Optional.of(stringBuilder.toString());
        } else
        {
          return Optional.empty();
        }
    }
}
