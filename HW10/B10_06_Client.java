import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class B10_06_Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        var reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)
        );
        var writer = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);

        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть число (кратність): ");
        int d = sc.nextInt();
        sc.nextLine();
        writer.println(d);

        while (true) {
            System.out.print("Введіть рядок чисел або END: ");
            String line = sc.nextLine();
            writer.println(line);

            if (line.equals("END")) break;

            String answer = reader.readLine();
            System.out.println("Кратних: " + answer);
        }

        socket.close();
    }
}
