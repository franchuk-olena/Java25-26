package Home.HW5;

public class B05_01 {

    public static void main(String[] args) {
        String s = "Це приклад рядка (цей текст потрібно видалити) і ще текст.";

        String result = removeParenthesesContent(s);
        System.out.println("Рядок після видалення дужок та вмісту:");
        System.out.println(result);
    }

    /* Метод видаляє символи між '(' та ')' включно */
    public static String removeParenthesesContent(String s) {
        StringBuilder sb = new StringBuilder();
        boolean inside = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                if (inside) {
                    System.out.println("Помилка: неправильне вкладення дужок!");
                    return "";
                }
                inside = true;
            } else if (c == ')') {
                if (!inside) {
                    System.out.println("Помилка: закриваюча дужка без відкриваючої!");
                    return "";
                }
                inside = false;
            } else {
                if (!inside) {
                    sb.append(c);
                }
            }
        }

        if (inside) {
            System.out.println("Помилка: є незакриті дужки!");
            return "";
        }

        return sb.toString();
    }
}
