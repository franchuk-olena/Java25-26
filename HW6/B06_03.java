package HW6;

public class B06_03 {
    public static void main(String[] args) {
        String expr1 = "+2 - 57*33 + 25/ - 4";
        String expr2 = "+2 - 57*33/";

        String regex = "\\s*[+-]?\\s*\\d+(\\s*[+\\-*/]\\s*[+-]?\\s*\\d+)*\\s*";

        System.out.println(expr1);
        if (expr1.matches(regex)) {
            System.out.println("Вираз синтаксично правильний.");
        } else {
            System.out.println("Вираз містить помилку.");
        }

        System.out.println(expr2);
        if (expr2.matches(regex)) {
            System.out.println("Вираз синтаксично правильний.");
        } else {
            System.out.println("Вираз містить помилку.");
        }
    }


}