public class Task1 
{
    /* #1 Напишите функцию, которая принимает целое число минут и преобразует его в
секунды. */
    public static int convert(int a)
    {
        return a * 60;
    }

    /*#2 Вы подсчитываете очки за баскетбольный матч, учитывая количество забитых 2-х
и 3-х очков, находите окончательные очки для команды и возвращаете это
значение. */
    public static int points(int a, int b)
    {
        return a*2 + b*3;
    }

    /*#3 Создайте функцию, которая принимает количество побед, ничьих и поражений и
вычисляет количество очков, набранных футбольной командой на данный момент.
выигрыш – получают 3 очка
ничья – получают 1 очко
проигрыш – получают 0 очков
 */
    public static int footballPoints(int a, int b, int c)
    {
        return a*3 + b;
    }

    /*#4 Создайте функцию, которая возвращает true, если целое число равномерно делится
на 5, и false в противном случае. */
    public static boolean divisibleByFive(int a)
    {
        return a % 5 == 0;
    }
    /*#5 Создайте функцию с помощью оператора &&. */
    public static boolean and(boolean a, boolean b)
    {
        if ((a == true) && (b == true))
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    /*#6 У меня есть ведро с большим количеством темно-синей краски, и я хотел бы
покрасить как можно больше стен. Создайте функцию, которая возвращает
количество полных стен, которые я могу покрасить, прежде чем мне нужно будет
отправиться в магазины, чтобы купить еще.
n - это количество квадратных метров, которые я могу нарисовать.
w и h-это ширина и высота одной стены в метрах. */
    public static double howManyWalls(double n, double w, double h)
    {
        int x = 0;
        while(n >= w*h) 
        {
            n -= w*h;
            x++;
        }
        return x;
    }
    /*#7 Исправьте код, чтобы решить эту задачу (только синтаксические ошибки).
Посмотрите на приведенные ниже примеры, чтобы получить представление о том,
что должна делать эта функция. */
    public static int squared(int a) 
    {
        return a * a;
    }
    /*#8 Создайте функцию, которая принимает три аргумента prob, prize, pay и возвращает
true, если prob * prize > pay; в противном случае возвращает false.*/
    public static boolean profitableGamble(double prob, double prize, double pay)
    {
        return prob * prize > pay;
    }
    /*#9 Создайте метод, который возвращает количество кадров, показанных за заданное
количество минут для определенного FPS. */
    public static int frames(int mins, int fps)
    {
        return mins*60*fps;
    }
    /*#10 Создайте функцию, которая будет работать как оператор модуля % без
использования оператора модуля. Оператор модуля-это способ определения
остатка операции деления. Вместо того чтобы возвращать результат деления,
операция по модулю возвращает остаток целого числа. */  
    public static double mod(double a, double b)
    {
        double result = a;
        while(result - b >= 0) 
        {
            result -= b;
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(convert(5));
        System.out.println(points(13, 12));
        System.out.println(footballPoints(3, 4, 2));
        System.out.println(divisibleByFive(5));

        System.out.println(and(true, false));
        System.out.println(and(true, true));

        System.out.println(howManyWalls(46, 5, 4));
        System.out.println(squared(9));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(frames(10, 25));
        System.out.println(mod(218, 5));
    }
}
