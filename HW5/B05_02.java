package Home.HW5;

public class B05_02 {

    public static void main(String[] args) {
        String s = "3abc";  // Тут можна вставити будь-який рядок для перевірки

        System.out.println("Рядок: " + s);
        System.out.println("Властивість a: " + checkPropertyA(s));
        System.out.println("Властивість b: " + checkPropertyB(s));
        System.out.println("Властивість c: " + checkPropertyC(s));
    }

    // a) рядок починається з ненульової цифри, далі тільки літери, кількість літер = цифрі
    public static boolean checkPropertyA(String s) {
        if (s.isEmpty()) return false;

        char first = s.charAt(0);
        if (!Character.isDigit(first) || first == '0') return false;

        int countLettersExpected = first - '0';
        String rest = s.substring(1);

        if (rest.length() != countLettersExpected) return false;

        for (char c : rest.toCharArray()) {
            if (!Character.isLetter(c)) return false;
        }

        return true;
    }

    // b) рядок містить тільки одну цифру, і її числове значення = довжині рядка
    public static boolean checkPropertyB(String s) {
        int digitCount = 0;
        int digitValue = -1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
                digitValue = c - '0';
            } else if (!Character.isLetter(c)) {
                return false;
            }
        }

        return digitCount == 1 && digitValue == s.length();
    }

    // c) сума числових значень цифр = довжина рядка
    public static boolean checkPropertyC(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            } else if (!Character.isLetter(c)) {
                return false;
            }
        }
        return sum == s.length();
    }
}
