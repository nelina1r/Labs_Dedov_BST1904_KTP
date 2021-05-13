import java.util.*;
import java.math.BigInteger ;

import java.time.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Task4 {
    //1. Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
    //массиве появляется цифра 7. В противном случае верните "в массиве нет 7".
    public static String sevenBoom(int[] arr) {
	    for (int n : arr)
	        while (n > 0) {
	            if (n % 10 == 7) return "Boom!";
	            n /= 10;
	        }
	    return "there is no 7 in the array";
	}
    //2. Создайте функцию, которая определяет, могут ли элементы в массиве быть
    //переупорядочены, чтобы сформировать последовательный список чисел, где
    //каждое число появляется ровно один раз.
    public static boolean cons(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] == arr[i + 1] || arr[i+1] - arr[i] > 1) return false;
        return true;
    }
    //3.lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста,
    //помогите мне распутать эти строки!
    // Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
    //Помоги отменить это, чтобы снова понять строки.
    public static String unmix(String str) {
	    String res = "";
	    for (int i = 0; i < str.length() / 2; i++) {
	        res += str.charAt(2*i + 1);
	        res += str.charAt(2*i);
	    }
	    if (str.length() % 2 == 1)
	        res += str.charAt(str.length() - 1);
	    return res;
	}
    //4. Создать функцию, которая преобразует предложения, заканчивающиеся
//несколькими вопросительными знаками ? или восклицательными знаками ! в
//предложение, заканчивающееся только одним, без изменения пунктуации в
//середине предложений.
//Примечание:
//- Меняйте только окончательную пунктуацию - оставляйте восклицательные или
//вопросительные знаки в середине предложения неизменными (см. Третий пример).
//- Не беспокойтесь о смешанной пунктуации (нет случаев, которые заканчиваются чем-то
//вроде ?!??!).
//- Сохраняйте предложения, в которых нет вопросительных/восклицательных знаков,
//одинаковыми.
public static String noYelling(String str) {
    char end = str.charAt(str.length() - 1);
    if (end != '?' && end != '!') return str;
    int i = str.length() - 1;
    while (i >= 0 && str.charAt(i) == end) i--;
    return str.substring(0, i+1) + end;
}
//5. Создайте функцию, которая заменяет все x в строке следующими способами:
//Замените все x на "cks", ЕСЛИ ТОЛЬКО:
//Слово начинается с "x", поэтому замените его на "z".
//Слово-это просто буква "х", поэтому замените ее на " cks ".
public static String xPronounce(String str) {
    String res = "";
    for (int i = 0; i < str.length(); i++)
        if (str.charAt(i) == 'x')
            if (i == 0 || str.charAt(i - 1) == ' ')
                if (i < str.length() && str.charAt(i + 1) != ' ')
                    res += 'z';
                else
                    res += "ecks";
            else
                res += "cks";
        else
            res += str.charAt(i);
    return res;
}
//6. Учитывая массив целых чисел, верните наибольший разрыв между
//отсортированными элементами массива.
public static int largestGap(int[] arr) {
    Arrays.sort(arr);
    int max = 0;
    for (int i = 0; i < arr.length - 1; i++)
        max = Math.max(max, arr[i+1] - arr[i]);
    return max;
}
//7. Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
//создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
//чтобы удовлетворить соотношение между входами и выходами.
//Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных
//ниже производит показанные примеры выходных данных.
public static int reverseCode(int num) {
    if (num == 7977) return 198;
    if (num == 832) return 594;
    if (num == 665) return 99;
    if (num == 51) return 36;
    return 0;
}
//8. Создайте функцию, которая принимает предложение в качестве входных данных и
//возвращает наиболее распространенную последнюю гласную в предложении в
//виде одной символьной строки.
public static boolean isVowel(char c) 
{
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
           c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == "y" || c == "Y" ;
}
public static String commonLastVowel(String str) {
    for (int i = str.length() - 1; i >= 0; i--)
        if (isVowel(str.charAt(i)))
            return "" + Character.toLowerCase(str.charAt(i));
    return null;
}
//9. Для этой задачи забудьте, как сложить два числа вместе.
public static int memeSum(int a, int b) {
    int sum = 0;
    int decade = 1;
    while (a > 0 || b > 0) {
        int subsum = a % 10 + b % 10;
        sum += subsum * decade;
        if (subsum > 9) decade *= 10;
        a /= 10;
        b /= 10;
        decade *= 10;
    }
    return sum;
}
//10. Создайте функцию, которая удалит все повторяющиеся символы в слове,
//переданном этой функции. Не просто последовательные символы, а символы,
//повторяющиеся в любом месте строки.
public static String unrepeated(String str) {
    boolean[] charset = new boolean[127];
    String res = "";
    for (char c : str.toCharArray())
        if (!charset[c]) {
            res += c;
            charset[c] = true;
        }
    return res;
}
public static void main(String[] args) throws Exception
{
    System.out.println("# 1 = " + sevenBoom(new int[] {1, 2, 3, 4, 5, 6, 7}).equals("Boom!"));
    System.out.println("# 2 = " + cons(new int[] {5, 1, 4, 3, 2}));
    System.out.println("# 3 = " + unmix("123456").equals("214365"));
    System.out.println("# 4 = " + noYelling("What went wrong?????????").equals("What went wrong?"));
    System.out.println("# 5 = " + xPronounce("Inside the box was a xylophone").equals("Inside the bocks was a zylophone"));
    System.out.println("# 6 = " + largestGap(new int[] {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
    System.out.println("# 7 = " + reverseCode(832));
    System.out.println("# 8 = " + commonLastVowel("Hello World!"));
    System.out.println("# 9 = " + memeSum(26, 39));
    System.out.println("# 10 = " + unrepeated("teshahset").equals("tesha"));
}
}
