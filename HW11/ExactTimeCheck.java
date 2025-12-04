import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;

public class ExactTimeCheck {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://time.is/Kyiv");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // ОБОВʼЯЗКОВО — інакше сайт дасть 403 або редірект
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        StringBuilder html = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            html.append(line);
        }
        in.close();

        String page = html.toString();

        // -------------------------------
        // Витягуємо <time id="clock">HH:MM:SS</time>
        // -------------------------------
        String startTag = "<time id=\"clock\">";
        String endTag = "</time>";

        int start = page.indexOf(startTag);
        int end = page.indexOf(endTag, start);

        // Між цими двома тегами міститься точний час
        String exactTime = page.substring(start + startTag.length(), end);

        System.out.println("Точний час (із сайту): " + exactTime);

        // Локальний час, секунда в секунду (без наносекунд)
        LocalTime localTime = LocalTime.now().withNano(0);
        System.out.println("Локальний час:         " + localTime);

        // Порівнюємо
        if (exactTime.equals(localTime.toString())) {
            System.out.println("✔ Час на комп’ютері точний.");
        } else {
            System.out.println("✖ Час відрізняється.");
        }
    }
}
