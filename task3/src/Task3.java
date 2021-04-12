import java.util.Arrays;
import java.util.OptionalDouble;

import static java.lang.Math.*;

public class Task3 
{

    /*#1 Учитывая массив городов и населения, верните массив, в котором все население
округлено до ближайшего миллиона. */
    public static String[][] millionsRounding(String[][] str)
    {
        double r_p = 0;
        for (int i = 0; i < str.length; i++)
        {
            int ppl = Integer.parseInt(str[i][1]);
            r_p = Math.round(ppl / Math.pow(10, 6)) * Math.pow(10, 6);
            str[i][1] = String.valueOf(r_p);
        }
        return str;
    }

    /*#2 Учитывая самую короткую сторону треугольника 30° на 60° на 90°, вы должны
найти другие 2 стороны (верните самую длинную сторону, сторону средней
длины). */
    public static double[] otherSides(int a) {
        //sides
        int b = 2 * a;
        double cr;
        double c = a * sqrt(3);
        //search max nd average
        double maxi = max(c, max(a, b));
        double mini = min(c, min(a, b));
        if ((a == maxi && b == mini) || (b == maxi && a == mini)) {
            cr = c;
        } else {
            if ((a == maxi && c == mini) || (c == maxi && a == mini)) {
                cr = b;
            } else {
                cr = a;
            }
        }
        //round
        double scale=Math.pow(10,2);
        cr=Math.ceil(cr*scale)/scale;
        return new double[]{maxi,cr};
    }

    /*#3 Создайте функцию, имитирующую игру "камень, ножницы, бумага". Функция
принимает входные данные обоих игроков (камень, ножницы или бумага), первый
параметр от первого игрока, второй от второго игрока. Функция возвращает
результат как таковой:
"Игрок 1 выигрывает"
"Игрок 2 выигрывает"
"НИЧЬЯ" (если оба входа одинаковы)*/
public static String rps(String s, String g){
    if ((s.equals("rock") & g.equals("paper"))) 
        return "Player 2 wins";
    if ((s.equals("scissors") & g.equals("rock"))) 
        return "Player 2 wins";
    if ((s.equals("paper") & g.equals("scissors"))) 
        return "Player 2 wins";
    if ((s.equals("paper") & g.equals("rock"))) 
        return "Player 1 wins";
    if ((s.equals("rock") & g.equals("scissors"))) 
        return "Player 1 wins";
    if ((s.equals("scissors") & g.equals("paper"))) 
        return "Player 1 wins";
    return "TIE";
    }


    /*#4 Создайте функцию, которая берет массив целых чисел, суммирует четные и нечетные
числа отдельно, а затем возвращает разницу между суммой четных и нечетных чисел.*/
    public static int warOfNumbers(int[] arr) 
    {
        int ch = 0;
        int nech =0;
        for (int i : arr) 
        {
            if (i % 2 == 0) 
                ch += i;
            else 
                nech += i;
        }
        if (ch > nech) 
            return ch - nech;
        else 
            return nech - ch;
    }

    /*#5  Учитывая строку, создайте функцию для обратного обращения. Все буквы в
нижнем регистре должны быть прописными, и наоборот.*/
    public static String reverseCase(String text)
    {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if (Character.isUpperCase(c))
            {
                chars[i] = Character.toLowerCase(c);
            }
            else if (Character.isLowerCase(c))
            {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    /*#6 Создайте функцию, которая принимает строку из одного слова и выполняет
следующие действия:
Конкатенирует inator до конца, если слово заканчивается согласным, в противном
случае вместо него конкатенирует -inator */
    public static String inat(String st)
    {
        char[] st_arr = st.toCharArray();
        int k = st_arr.length * 1000;
        char[] glas = {'a','e','i','o','u','y'};
        String s = "";
        for (char check : glas) 
        {
            if (check == st_arr[st_arr.length - 1]) 
            {
                s = st + "-inator" + " " + k;
            } else {
                s = st + "inator" + " " + k;
            }
        }
        return s;
    }

    /*#7 Напишите функцию, которая принимает три измерения кирпича: высоту(a),
ширину(b) и глубину(c) и возвращает true, если этот кирпич может поместиться в
отверстие с шириной(w) и высотой(h). */
    public static boolean doesBrickFit(int a, int b, int c, int w, int h)
    {
        return (((w>=a||w>=b)&&h>=c)||((w>=a||w>=c)&&h>=b)||((w>=b||w>=c)&&h>=a));
    }

    /*#8 Напишите функцию, которая принимает топливо (литры), расход топлива
(литры/100 км), пассажиров, кондиционер (логическое значение) и возвращает
максимальное расстояние, которое может проехать автомобиль. */
    public static double totalDistance(double litres, double rash, int pass,boolean cond)
    {
        rash = rash * (pass * 5/100) + rash;
        if (cond) 
            rash = rash * 110/100;
        return litres/rash * 100;
    }

    /*#9 Создайте функцию, которая принимает массив чисел и возвращает среднее
значение (average) всех этих чисел.*/
    public static double mean(double[] arr)
    {
        OptionalDouble average = Arrays.stream(arr).average();
        return average.getAsDouble();
    }

    /*#10 Создайте функцию, которая принимает число в качестве входных данных и
возвращает true, если сумма его цифр имеет ту же четность, что и все число. В
противном случае верните false.*/ 
    public static boolean parityAnalysis(int a)
    {
        int sum = 0;
        int b = a;
        while (a > 0)
        {
            sum += a%10;
            a /= 10;
        }
        return b%2 == sum%2;
    }

    public static void main(String[] args) throws Exception 
    {
        String[][] city = {{"Manila", "5354553"},{"Kuala Lumpur", "7996830"}, {"Jakarta", "1077048"}};
        System.out.println("# 1 = " );
        millionsRounding(city);
        for (int i = 0; i < city.length; i++)
        {
            for (int j = 0; j < city[i].length; j++)
            {
                System.out.print(city[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("# 2 = " + Arrays.toString(otherSides(12)));
        System.out.println("# 3 = " + rps("scissors", "scissors"));
        System.out.println("# 4 = " + warOfNumbers(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));
        System.out.println("# 5 = " + reverseCase("Happy Birthday"));
        System.out.println("# 6 = " + inat("oooo"));
        System.out.println("# 7 = " + doesBrickFit(1,1,1,1,1));
        System.out.println("# 8 = " + totalDistance(36.1, 8.6, 3, true));
        System.out.println("# 9 = " + mean(new double[] {1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println("# 10 = " + parityAnalysis(3));
    }
}
