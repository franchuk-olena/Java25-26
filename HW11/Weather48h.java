import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Weather48h {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть місто англійською: ");
        String city = sc.nextLine().trim().toLowerCase();

        // використовуємо ext — доступну версію сторінки
        String link = "https://www.timeanddate.com/weather/ukraine/" + city + "/ext";

        HttpURLConnection con = (HttpURLConnection) new URL(link).openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder html = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            html.append(line);
        }
        br.close();

        String page = html.toString();

        System.out.println("\nПрогноз погоди (EXT) для міста: " + city.toUpperCase());
        System.out.println("---------------------------------------------");

        // таблиця forecast
        String tableStart = "<table class=\"zebra tb-wt fw tb-hover\">";
        int pos = page.indexOf(tableStart);

        if (pos == -1) {
            System.out.println("Таблицю прогнозу не знайдено.");
            return;
        }

        String table = page.substring(pos);

        // рядки таблиці
        String[] rows = table.split("<tr>");

        int count = 0;

        for (String r : rows) {
            if (r.contains("rbi") && r.contains("%")) {

                String temp = extract(r, "rbi\">", "</td>");
                String hum = extract(r, "<td>", "%");

                System.out.printf("%2d) Температура: %-6s  Вологість: %s%%\n",
                        (count + 1), clean(temp), clean(hum));

                count++;
                if (count == 14) break;
            }
        }

        if (count == 0) {
            System.out.println("Не знайдено жодного пункту прогнозу.");
        }
    }

    private static String extract(String source, String start, String end) {
        int s = source.indexOf(start);
        if (s == -1) return "";
        s += start.length();
        int e = source.indexOf(end, s);
        if (e == -1) return "";
        return source.substring(s, e);
    }

    private static String clean(String s) {
        return s.replace("&nbsp;", " ")
                .replace("&minus;", "-")
                .replace("&deg;", "")
                .trim();
    }
}
