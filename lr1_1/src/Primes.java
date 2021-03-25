
import java.util.ArrayList;

public class Primes 
{
    public static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception 
    {
        for (int i = 2; i < 100; i++) 
        {
            if (isPrime(i)) 
            {
                System.out.println(i);
                primes.add(i);
            }
        }
    }


    public static boolean isPrime(int n) 
    {
        // Проверка числа на простоту
        // Поскольку у нас есть список всех простых чисел до n
        // то по основная теореме арифметики достаточно проверить только их
        for (int prime : primes) 
        {
            // причем если квадрат простого числа больше n
            // это значит, что n не делится ни на какое число <= prime
            // и можно считать это число следующим по очереди простым числом
            if (prime*prime > n)
                break;
            else if (n % prime == 0)
                return false;
        }   
        return true;
    } 
}
