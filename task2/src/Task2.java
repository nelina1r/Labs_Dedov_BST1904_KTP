import java.util.*;

public class Task2 
{
    /*#1 Теша шел по прямой улице, по обеим сторонам которой стояло ровно n
одинаковых домов. Она заметила, что четные дома увеличиваются справа, а нечетные уменьшаются слева.
Создайте функцию, которая принимает номер дома и длину улицы n и возвращает номер
дома на противоположной стороне. */
    public static int oppositeHouse(int num, int len)
    {
        return len * 2 - (num - 1);
    }

    /*#2 Создайте метод, который принимает строку (имя и фамилию человека) и
возвращает строку с заменой имени и фамилии. */ 
    public static String nameShuffle(String str)
    {
        List Words = Arrays.asList(str.split(" "));
        Collections.reverse(Words);
        return String.join(" ", Words);
    }

    /*#3 Создайте функцию, которая принимает два аргумента: исходную цену и процент
скидки в виде целых чисел и возвращает конечную цену после скидки. */
    public static double discount(double price, double discount)
    {
        return price - discount * price / 100;
    }

    /*#4 Создайте функцию, которая принимает массив и возвращает разницу между
наибольшим и наименьшим числами. */ 
    public static double differenceMaxMin(int[] arr)
    {
        Arrays.sort(arr);
        return (arr[arr.length - 1] - arr[0]);
    }

    /*#5 Создайте функцию, которая принимает три целочисленных аргумента (a, b, c) и
возвращает количество целых чисел, имеющих одинаковое значение. */
    public static int equal(int a, int b, int c)
    {
        int kolvo = 0;
        if (a == b) 
            kolvo++;
        if (a == c) 
            kolvo++;
        if (b == c) 
            kolvo++;
        if (((a == c) & (a != b)) || ((b == c) & (a != b)) || ((a == b) & (a != c))) 
            kolvo++;
        return kolvo;
    }

    /*#6 Создайте метод, который принимает строку в качестве аргумента и возвращает ее в обратном порядке.
*/
    public static String reverse(String s) 
    {
        return new StringBuilder(s).reverse().toString();
    }

    /*#7 Вы наняли трех программистов и (надеюсь) платите им. Создайте функцию, которая принимает три
    числа(почасовая заработная плата каждого программиста) и возвращает разницу между самым высокооплачиваемым
    программистом и самым низкооплачиваемым.*/
    public static int programmers(int pr1, int pr2, int pr3)
    {
        int[] arr = new int[3];
        arr[0] = pr1; arr[1] = pr2; arr[2] = pr3;
        Arrays.sort(arr);
        return (arr[2] - arr[0]);
    }

    /*#8 Создайте функцию, которая принимает строку, проверяет, имеет ли она одинаковое количество x и o и возвращает либо true, либо false.
Правила:
- Возвращает логическое значение (true или false).
- Верните true, если количество x и o одинаковы.
- Верните false, если они не одинаковы.
- Строка может содержать любой символ.
- Если "x" и "o" отсутствуют в строке, верните true.*/
    public static boolean getXO(String s) {
        int countX = 0, countO = 0;
        char[] t = s.toCharArray();
        for (char c : t) {
            if (c == 'x' || c == 'X') countX++;
            if (c == 'o' || c == 'O') countO++;
        }
        return countO == countX;
    }

/*#9 Напишите функцию, которая находит слово "бомба" в данной строке.
Ответьте "ПРИГНИСЬ!", если найдешь, в противном случае:"Расслабься, бомбы нет".
Примечание:
Строка "бомба" может появляться в разных случаях символов (например, в верхнем, нижнем регистре, смешанном) */
    public static String bomb(String str) 
    {
        str.toLowerCase();
        if (str.contains("bomb")) {
            return "ПРИГНИСЬ!";
        } else {
            return "Расслабься, бомбы нет";
        }
    }

    /*#10 Возвращает true, если сумма значений ASCII первой строки совпадает с суммой значений ASCII второй строки,
в противном случае возвращает false*/
    public static boolean sameAscii(String str1, String str2){
        int Sum1 = 0; int Sum2 = 0;
        char[] ascii1 = str1.toCharArray();
        char[] ascii2 = str2.toCharArray();
        for (char c : ascii1) {
            Sum1 += c;
        }
        for (char c : ascii2) {
            Sum2 += c;
        }
        return Sum1 == Sum2;
    }


    public static void main(String[] args) throws Exception 
    {
        System.out.println("№ 1 = " + oppositeHouse(1, 3));
        System.out.println("№ 2 = " + nameShuffle("Donald Trump"));
        System.out.println("№ 3 = " + discount(89, 20));
        System.out.println("№ 4 = " + differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println("№ 5 = " + equal(1, 1, 1));
        System.out.println("№ 6 = " + reverse("Hello World"));
        System.out.println("№ 7 = " + programmers(1, 5, 9));
        System.out.println("№ 8 = " + getXO("ooxx"));
        System.out.println("№ 9 = " + bomb("There is a bomb."));
        System.out.println("№ 10 = " + sameAscii("AA", "B@"));
    }
}
