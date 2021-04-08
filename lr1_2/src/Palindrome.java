public class Palindrome 
{
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s))
                System.out.printf("%s это палиндром\n", s);
            else
                System.out.printf("%s это не палиндром\n", s);
        }
    }
    
    public static String reverse(String s) {
        // Переворачивает строку в обратном порядке
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
    
    public static boolean isPalindrome(String s) {
        // проверка, что строка является палиндромом
        return s.equals(reverse(s));
    } 
}
