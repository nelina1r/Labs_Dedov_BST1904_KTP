import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Answer 1 = " + sevenBoom(new int[] {1, 2, 3, 4, 5, 6, 97}));
        System.out.println("Answer 2 = " + cons (new int[] {5, 6, 7, 8, 9, 13}));
        System.out.println("Answer 3 = " + unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println("Answer 4 = " + noYelling("Oh my goodness!!!"));
        System.out.println("Answer 5 = " + xPronounce("xMG x box unboxing video x D") );
        System.out.println("Answer 6 = " + largestGap(new int[] {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println("Answer 7 = " + raznitsa(832));
        System.out.println("Answer 8 = " + commonLastVowel("Watch the characters dance!"));
        System.out.println("Answer 9 = " + memeSum(26, 39));
        System.out.println("Answer 10 = " + unrepeated("hello"));
    }

// 1 Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
// массиве появляется цифра 7. В противном случае верните "в массиве нет 7".

    public static String  sevenBoom (int[] seven)
    { 
        int a = 0;
        String s;
    for (int i: seven)
    {
        s = Integer.toString(i); // число в строку
        if (s.contains("7"))
        { 
            a +=1;
        }
    }
    if (a>0) return "BOOM!";
    else return "there is no 7 in the array";
    }

// 2. Создайте функцию, которая определяет, могут ли элементы в массиве быть
// переупорядочены, чтобы сформировать последовательный список чисел, где
// каждое число появляется ровно один раз.
    public static boolean cons(int[] sort){
        boolean k = false;
        Arrays.sort(sort); // класс arrays, метод сорт
       for(int i = 1; i < sort.length; i++){
           k = sort[i] - sort[i - 1] == 1;
       }
        return k;
    }

// 3. lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста,
// помогите мне распутать эти строки!
    public static String unmix(String mix){
        char obm;
        char[] a = mix.toCharArray();
        for(int i = 0; i < a.length; i += 2){
            obm = a[i];
            a[i] = a[i+1];
            a[i+1]=obm;
        }
        return String.valueOf(a); //возвращает строковое представление int аргумента
    }

//4 Создать функцию, которая преобразует предложения, заканчивающиеся
// несколькими вопросительными знаками ? или восклицательными знаками ! в
// предложение, заканчивающееся только одним, без изменения пунктуации в
// середине предложений.
    public static String noYelling(String yell){
        while (yell.endsWith("!!") || yell.endsWith("??")) {
            yell = yell.substring(0, yell.length() - 1); // удаление последнего элемента строки
        }
        return yell;
    }

// 5. Создайте функцию, которая заменяет все x в строке следующими способами:
// Замените все x на "cks", ЕСЛИ ТОЛЬКО:
// Слово начинается с "x", поэтому замените его на "z".
// Слово-это просто буква "х", поэтому замените ее на " ecks ".
public static String xPronounce(String str) {
    String res = "";
    for (int i = 0; i < str.length(); i++)
        if (str.charAt(i) == 'x')
            if (i == 0 || str.charAt(i - 1) == ' ')   //начало слова
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
// 6. Учитывая массив целых чисел, верните наибольший разрыв между
// отсортированными элементами массива.
    public static int largestGap (int[] gap){
        Arrays.sort(gap);
        int r = 0;
        for(int i = 0; i< gap.length - 1 ;i++)
        if ((gap[i+1] - gap[i])>r)
            r = gap[i+1] - gap[i];
        return r;
    }
// 7. Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
// создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
// чтобы удовлетворить соотношение между входами и выходами.
public static int raznitsa(int num) {
    char[] numCA = Integer.toString(num).toCharArray();
        Arrays.sort(numCA);
        int numInOrder = Integer.parseInt(new String(numCA));
        if(num>numInOrder)
            return num-numInOrder;
    return 0;
}

//8 Создайте функцию, которая принимает предложение в качестве входных данных и
// возвращает наиболее распространенную последнюю гласную в предложении в
// виде одной символьной строки.
public static boolean isVowel(char ch) {
    if (ch == 'a' || ch == 'e' || ch == 'i'
            || ch == 'o' || ch == 'u' || ch == 'y') {  //чек на гласную
        return true;
    }
    return false;
}
public static String commonLastVowel(String string) {
    String lasts = "";
    string = string.toLowerCase();
    for (int i = 0; i < string.length(); i++) {
        if (!isVowel(string.charAt(i)) || ((!Character.isLetter(string.charAt(i)) || i + 1 != string.length())
                && (!Character.isLetter(string.charAt(i)) || Character.isLetter(string.charAt(i + 1))))) {
            continue;
        }
        lasts += string.charAt(i);
    }
    String max = "" + lasts.charAt(0);
    int max_c = 0; //максимальное значение повторений
    int count = 0;
    for (int i = 0; i < lasts.length() - 1; i++) {
        count = 1;
        for (int j = i + 1; j < lasts.length(); j++) {
            if (lasts.charAt(i) == lasts.charAt(j)) count++;
        }
        if (count > max_c) {
            max_c = count;
            max = "" + lasts.charAt(i);
        }
    }
    return max;
}

//9 Для этой задачи забудьте, как сложить два числа вместе. Лучшее объяснение того,
// что нужно сделать для этой функции, - это этот мем:
//  248 + 208 = 4416
    public static int memeSum(int a1, int a2){
        int len = Math.max(String.valueOf(a1).length(),String.valueOf(a2).length());
        String w  = "";
        for (int i = len - 1; i>= 0 ; i--){
            w = (a1 % 10 + a2 % 10) + w;
            a1 /=10;
            a2 /=10;
        }
        return Integer.parseInt(w);
    }

//10 Создайте функцию, которая удалит все повторяющиеся символы в слове,
// переданном этой функции. Не просто последовательные символы, а символы,
// повторяющиеся в любом месте строки
public static String unrepeated (String str){
StringBuilder rez = new StringBuilder();
for(int i=0; i< str.length(); i++){
    if (!rez.toString().contains(String.valueOf(str.charAt(i)))) //добавление неповторяющейся буквы
        rez.append(str.charAt(i));
}
    return rez.toString();
}
}