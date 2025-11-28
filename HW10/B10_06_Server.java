import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class B10_06_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started...");

        Socket socket = server.accept();
        System.out.println("Client connected.");

        var reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)
        );
        var writer = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);

        int divisor = Integer.parseInt(reader.readLine());
        System.out.println("Divisor: " + divisor);

        while (true) {
            String line = reader.readLine();
            if (line == null || line.equals("END")) break;

            String[] parts = line.trim().split("\\s+");
            int count = 0;

            for (String p : parts) {
                int num = Integer.parseInt(p);
                if (num % divisor == 0) count++;
            }

            writer.println(count);
            System.out.println("Sent: " + count);
        }

        socket.close();
        server.close();
    }
}
