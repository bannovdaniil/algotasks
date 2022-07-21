package practicum;

import java.util.List;

public class Algorithms {

    /**
     *
     * В задачах, в которых заранее не оговорен состав символов в строках,
     * строки могут содержать русские и английские буквы,
     * а также пробелы, знаки препинания, кавычки и скобки.
     *
     * Не использовать при решении регулярные выражения, методы стандартных библиотек
     * java.util.Collections, java.util.Arrays, java.lang.Math, а также методы
     * replace и replaceAll, reverce, equals, indexOf, toLowerCase, toUpperCase
     * split, substring из java.lang.String.
     * Можете использовать циклы, условные операторы,
     * простые типы данных и их обертки.
     *
     * Как изменится сложность ваших решений, если убрать
     * ограничения по использованию функций Java API?
     */

    /**
     * Вычислите максимальное, минимальное и среднее число для списка чисел
     * Верните их сумму
     * Список гарантированно содежит элементы
     */
    public static double maxMinAvr(List<Integer> numbers) {
        int max = numbers.get(0);
        int min = max;
        int sum = 0;
        double count = numbers.size();

        for (var number : numbers) {
            sum += number;
            if (max < number) {
                max = number;
            } else if (min > number) {
                min = number;
            }
        }

        return sum / count + max + min;
    }


    /**
     * Найдите второе максимальное значение в массиве,
     * если такого нет, то вернуть первое
     * Массив гарантировано содержит элементы
     */
    public static Integer max2(List<Integer> list) {
        int max = list.get(0);
        int max2 = max;

        for (var number : list) {
            if (max < number) {
                max2 = max;
                max = number;
            }
        }

        return max2;
    }

    /**
     * Удалите число из массива.
     * Верните массив не содержащий этого элемента,
     * но и не содержащий "пропусков" на месте удаленных элементов
     * Например, если из массива [0, 6, 0 ,5, 0] нужно удалить элемент 0,
     * то возвращаться должен массив содержащий два элемента [6, 5]
     */
    public static int[] removeElementFromArray(int[] numbers, int value) {
        int[] freshArray = new int[numbers.length];
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != value) {
                freshArray[count++] = numbers[i];
            }
        }

        int[] rightLengthArray = new int[count];
        for (int i = 0; i < count; i++) {
            rightLengthArray[i] = freshArray[i];
        }
        return rightLengthArray;
    }

    /**
     * Удалите все гласные из строки.
     * Например, "мАма Мыла раму" -> "мм Мл рм"
     */
    public static String removeVowels(String str) {
        StringBuilder sb = new StringBuilder();
        List<Character> charsLo = List.of('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'ю', 'я', 'e', 'y', 'u', 'i', 'o', 'a');
        List<Character> charsUp = List.of('А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Ю', 'Я', 'E', 'Y', 'U', 'I', 'O', 'A');
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!charsLo.contains(ch) && !charsUp.contains(ch)) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }


    /**
     * Убрать повторяющиеся подряд символы в строке
     * например "ммммоолллокко" -> "молоко"
     * (*) - в этой задаче нужно учитывать сочетания
     * повторяющихся букв разного регистра,
     * при этом в выходной строке остается первая буква,
     * например, "мМммооЛллокКОоо" -> "моЛокО",
     */
    public static String removeDublicates(String str) {
        if (str.length() == 0) {
            return "";
        }

        char last = str.charAt(0);
        char ch = last;
        StringBuilder sb = new StringBuilder();
        sb.append(ch);

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if ((last == ch || last == ch + 32 || last == ch - 32)) {
                continue;
            }
            sb.append(ch);
            last = ch;
        }

        return sb.toString();
    }

    /**
     * Сжать строку, удаляя повторяющиеся символы
     * и указывая количество повторов для каждого символа
     * например "мооолооооккооо" -> "м1о3л1о4к2о2"
     */
    public static String zipStr(String str) {
        if (str.length() == 0) {
            return "";
        }

        int count = 0;
        char last = str.charAt(0);
        char ch = last;
        StringBuilder sb = new StringBuilder();
        sb.append(ch);

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (last == ch) {
                count++;
                continue;
            }
            sb.append(count);
            count = 1;
            sb.append(ch);
            last = ch;
        }
        sb.append(count);

        return sb.toString();
    }


    /**
     * Выяснить является ли строка палиндромом,
     * то есть  одинаково читается в обоих направлениях.
     * Например, слово "топот" - палиндром, а слово "топор" нет.
     * Строка "А роза упала на лапу Азора" тоже палиндром,
     * а строка "А роза уколола лапу Азора" нет.
     * "A man, a plan, a canal-Panama", тоже палиндром
     * <p>
     * (!) Так как запрещены регулярные выражения
     * и методы преобразования регистра символов из java.lang.String
     * обратите внимание таблицу кодов символов UTF-8
     * (лучше убрать эту подсказку и выдать ее в процессе)
     */
    public static boolean isPalindrom(String str) {
        boolean isPalindrom = true;
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            char chLeft = str.charAt(left++);
            if (chLeft < 'A' || chLeft > 'я') {
                continue;
            }
            char chRight = str.charAt(right--);
            if (chRight < 'A' || chRight > 'я') {
                left--;
                continue;
            }

            if (chLeft < chRight) {
                chLeft += 32;
            } else if (chRight < chLeft) {
                chLeft -= 32;
            }

            if (chLeft != chRight) {
                isPalindrom = false;
                break;
            }
        }

        return isPalindrom;
    }


    /**
     * Перевернуть все слова в предложении
     * "Кот лакал молоко" -> "тоК лакал околом"
     */
    public static String reverseWordsInSentence(String sentence) {
        StringBuilder reverse = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch != ' ') {
                if (ch < 'A' || ch > 'я') {
                    reverse.append(ch);
                } else {
                    reverse.insert(0, ch);
                }
            } else {
                sb.append(reverse);
                sb.append(' ');
                reverse = new StringBuilder();
            }
        }

        return sb.append(reverse).toString();
    }

    /**
     * Отсортируйте символы в массиве,
     * не используйте дополнительные структуры данных.
     * При вводе массива символов {'c', 'a', 'b'},
     * возвращаться должен тот же отсортированный массив {'a', 'b', 'c'}
     */
    public static char[] sortSymbols(char[] symbols) {
        for (int left = 0; left < symbols.length - 1; left++) {
            char minChar = symbols[left];
            int pos = left;
            for (int j = left + 1; j < symbols.length; j++) {
                if (minChar > symbols[j]) {
                    pos = j;
                    minChar = symbols[j];
                }
            }
            if (pos != left) {
                symbols[pos] = symbols[left];
                symbols[left] = minChar;
            }
        }
        return symbols;
    }


    /**
     * Выясните являются ли две строки анограммами.
     * Строки являются анограммами, если они состоят из одних и тех же букв
     * Например, слова "кот" и "ток" анограммы, а слова "кот" и  "кит" нет.
     */
    public static boolean isAnogramOf(String word, String anogram) {
        if (word.length() != anogram.length()) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
            sum -= anogram.charAt(i);
        }

        return sum == 0;
    }

    /**
     * Выясните, все ли символы в строке встречаются один раз.
     * Если строка содержит повторяющиеся символы,
     * то возвращать false, если не содержит - true
     * Нельзя использовать дополнительные структуры данных.
     * <p>
     * (!) В этой задаче строка может содержать
     * любой символ из таблицы ASCII (127 символов)
     * <p>
     * (!!) Сложность - O(n)
     */

    public static boolean hasUniqueChars(String str) {
        long cacheLo = 0;
        long cacheHi = 0;
        long cache = 0;
        long mask = 0;

        for (int left = 0; left < str.length(); left++) {
            char findChar = str.charAt(left);
            if (findChar > 127) {
                return false;
            }
            if (findChar < 64) {
                mask = 1 << findChar;
                cache = cacheLo;
                cacheLo |= mask;
            } else {
                findChar -= 64;
                mask = 1 << findChar;
                cache = cacheHi;
                cacheHi |= mask;
            }
            if (((cache & mask) ^ mask) == 0) {
                return false;
            }
        }
        return true;
    }
}
