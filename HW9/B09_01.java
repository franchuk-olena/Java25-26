package Home.HW9;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class B09_01 {

    static final String END = "";   // сигнал завершення (порожній рядок)

    public static void main(String[] args) throws Exception {

        double T1 = 1.5;   // секунди на читання рядка
        double T2 = 1.0;   // секунди обробки потоком 1
        double T3 = 2.0;   // секунди обробки потоком 2

        long t1 = (long)(T1 * 1000);
        long t2 = (long)(T2 * 1000);
        long t3 = (long)(T3 * 1000);

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(20);

        File input = new File("src/Home/HW9/input.txt");
        File out1 = new File("src/Home/HW9/worker01.txt");
        File out2 = new File("src/Home/HW9/worker02.txt");

        Thread reader = new Thread(() -> putFromFile(input, queue, t1));
        Thread worker1 = new Thread(() -> getAndProcess(queue, out1, t2));
        Thread worker2 = new Thread(() -> getAndProcess(queue, out2, t3));

        System.out.println("Start");

        reader.start();
        worker1.start();
        worker2.start();

        reader.join();
        worker1.join();
        worker2.join();

        System.out.println("End");
    }

    // ------------------------ ПОТІК ЧИТАННЯ ---------------------------

    public static void putFromFile(File file, ArrayBlockingQueue<String> queue, long time) {
        Thread.currentThread().setName("Reader");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println("Reader creating -> " + line);
                Thread.sleep(time);
                queue.put(line);
                System.out.println("Reader put -> " + line);
            }

            // Два робочих потоки → два сигнали завершення
            queue.put(END);
            queue.put(END);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ------------------------ ПОТІК ОБРОБКИ ---------------------------

    public static void getAndProcess(ArrayBlockingQueue<String> queue, File outFile, long time) {
        Thread.currentThread().setName("Worker-" + outFile.getName());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {

            while (true) {
                String msg = queue.take();
                System.out.println(Thread.currentThread().getName() + " extracted -> " + msg);

                if (msg.equals(END))
                    break;

                Thread.sleep(time);

                bw.write(msg);
                bw.newLine();
                System.out.println(Thread.currentThread().getName() + " processed -> " + msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
