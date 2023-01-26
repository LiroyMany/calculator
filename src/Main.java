import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int a, b;
    static char s;
    static int res;

    public static void main(String[] args) {
        while (true) {
            String in = sc.nextLine();
            char[] nr = new char[in.length()];

            for (int i = 0; i < in.length(); i++) {
                nr[i] = in.charAt(i);
                if (nr[i] == '+') {
                    s = '+';
                }
                if (nr[i] == '-') {
                    s = '-';
                }
                if (nr[i] == '*') {
                    s = '*';
                }
                if (nr[i] == '/') {
                    s = '/';
                }
            }
            String nrStroka = String.valueOf(nr);
            String[] n1 = nrStroka.split("[+*/-]");
            try {
                String a1 = n1[0];
                String b1 = n1[1];
                try {
                    String c1 = n1[2];
                    System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    break;
                } catch (ArrayIndexOutOfBoundsException u3) {
                    String a2 = a1.trim();
                    String b2 = b1.trim();
                    Boolean nor1 = numOrRome1(a2);
                    Boolean nor2 = numOrRome2(b2);
                    if (nor1 && nor2) {
                        a = Integer.parseInt(a2);
                        b = Integer.parseInt(b2);
                        res = calul(a, b, s);
                        System.out.println(res);
                    } else {
                        a = izRomeVNum(a2);
                        b = izRomeVNum(b2);
                        if (a == -1 || b == -1) {
                            if (nor1 || nor2) {
                                if(nor1 && b==-1 || nor2 && a ==-1) {
                                    System.out.println("Неверно введен операнд!");
                                    break;
                                }else{
                                    System.out.println("Нельзя использують одновременно разные системы счисления!");
                                    break;
                                }
                            } else {
                                if (a == -1 && b == -1) {
                                System.out.println("Неверно введены операнды!");
                                break;
                                } else {
                                System.out.println("Неверно введен операнд!");
                                break;
                                }
                            }
                        } else {
                            res = calul(a, b, s);
                            if (res < 0) {
                                System.out.println("В римской системе нет отрицательных чисел!");
                                break;
                            } else {
                                String resRome = izNumVRome(res);
                                System.out.println(resRome);
                            }
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException u4) {
                System.out.println("Строка не является математической операцией!");
                break;
            }
        }
    }
    private static boolean numOrRome1(String a2){
        try {
            int q1 = Integer.parseInt(a2);
            return true;
        }catch (NumberFormatException k1){
            return false;
        }
    }
    private static boolean numOrRome2( String b2){
        try {

            int q2 = Integer.parseInt(b2);
            return true;
        }catch (NumberFormatException k2){
            return false;
        }
    }

    public static int izRomeVNum(String rome) {
        try {
            if (rome.equals("I")) {
                return 1;
            }
            if (rome.equals("II")) {
                return 2;
            }
            if (rome.equals("III")) {
                return 3;
            }
            if (rome.equals("IV")) {
                return 4;
            }
            if (rome.equals("V")) {
                return 5;
            }
            if (rome.equals("VI")) {
                return 6;
            }
            if (rome.equals("IIV")) {
                return 7;
            }
            if (rome.equals("IIIV")) {
                return 8;
            }
            if (rome.equals("XI")) {
                return 9;
            }
            if (rome.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException oO) {
            throw new InputMismatchException("Неправильный ввод");
        }
        return -1;
    }
    public static String izNumVRome(int res) {
        String[] rome1 = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String r = rome1[res];
        return r;
    }

    public static int calul(int a, int b, char s) {
        int res = 0;
        switch (s){
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                try{
                    res = a / b;
                    break;
                }catch (ArithmeticException q){
                    System.out.println("На ноль делить нельзя!!!");
                    break;
                }
            default:
        }
        return res;
    }

}

