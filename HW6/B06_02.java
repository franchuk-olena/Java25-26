package HW6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_02 {
    public static void main(String[] args) {
        String text = "Контакти компанії:\n" +
                "Головний офіс: +1-800-555-12-34\n" +
                "Сервісний центр: 0449876543\n" +
                "Мобільний менеджера: 0931234567\n" +
                "Додатковий номер: +380 (67) 321-45-67";

        String regex = "\\+?\\d{1,3}?[-\\s]?\\(?\\d{2,3}\\)?[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}|\\d{10}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Знайдені номери телефонів:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
