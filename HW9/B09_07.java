package Home.HW9;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class B09_07 {

    static class Patient implements Runnable {
        private final int id;
        private final BlockingQueue<Patient> queue;

        public Patient(int id, BlockingQueue<Patient> queue) {
            this.id = id;
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println("Patient " + id + " arrived");
                queue.put(this);  // стає в чергу
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Doctor implements Runnable {
        private final int id;
        private final long serviceTime; // фіксований час для лікаря
        private final BlockingQueue<Patient> queue;
        private final Patient END;       // сигнал завершення

        public Doctor(int id, long serviceTime, BlockingQueue<Patient> queue, Patient END) {
            this.id = id;
            this.serviceTime = serviceTime;
            this.queue = queue;
            this.END = END;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Patient p = queue.take();
                    if (p == END) {
                        queue.put(END); // передаємо сигнал іншим лікарям
                        break;
                    }

                    System.out.println("Doctor " + id + " started patient " + p.id);
                    Thread.sleep(serviceTime);
                    System.out.println("Doctor " + id + " finished patient " + p.id);
                }
            } catch (InterruptedException e) {
                System.out.println("Doctor " + id + " interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int N = 3;      // кількість лікарів
        int M = 5;     // кількість пацієнтів
        long T1 = 500;  // мін інтервал приходу
        long T2 = 1500; // макс інтервал приходу
        long T3 = 1000; // мін час прийому
        long T4 = 3000; // макс час прийому

        Random rand = new Random();
        BlockingQueue<Patient> queue = new ArrayBlockingQueue<>(100);

        // спеціальний пацієнт для сигналу завершення
        Patient END = new Patient(-1, queue);

        Thread[] doctors = new Thread[N];
        for (int i = 0; i < N; i++) {
            long serviceTime = T3 + rand.nextInt((int) (T4 - T3 + 1));
            doctors[i] = new Thread(new Doctor(i, serviceTime, queue, END));
            doctors[i].setName("Doctor-" + i);
            doctors[i].start();
        }

        Thread[] patients = new Thread[M];
        for (int i = 0; i < M; i++) {
            Thread.sleep(T1 + rand.nextInt((int)(T2 - T1 + 1)));
            patients[i] = new Thread(new Patient(i+1, queue));
            patients[i].start();
        }

        // чекаємо, поки всі пацієнти стануть в чергу
        for (Thread p : patients) {
            p.join();
        }

        // після того як всі пацієнти створені, надсилаємо сигнал END лікарям
        queue.put(END);

        // чекаємо, поки лікарі завершать роботу
        for (Thread d : doctors) {
            d.join();
        }

        System.out.println("Simulation finished.");
    }
}
