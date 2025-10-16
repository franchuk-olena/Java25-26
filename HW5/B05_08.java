package Home.HW5;

import java.io.*;
import java.util.*;

class Cube {
    int size;
    String color;
    String material;

    public Cube(int size, String color, String material) {
        this.size = size;
        this.color = color;
        this.material = material;
    }

    @Override
    public String toString() {
        return size + "," + color + "," + material;
    }
}

public class B05_08 {

    public static List<Cube> readCubesFromFile(String filename) throws IOException {
        List<Cube> cubes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                int size = Integer.parseInt(parts[0].trim());
                String color = parts[1].trim();
                String material = parts[2].trim();
                cubes.add(new Cube(size, color, material));
            }
        }
        br.close();
        return cubes;
    }

    public static List<Cube> findCubesBySize(List<Cube> cubes, int size) {
        List<Cube> result = new ArrayList<>();
        for (Cube cube : cubes) {
            if (cube.size == size) {
                result.add(cube);
            }
        }
        return result;
    }

    public static Map<String, Integer> countCubesByColor(List<Cube> cubes) {
        Map<String, Integer> colorCount = new HashMap<>();
        for (Cube cube : cubes) {
            colorCount.put(cube.color, colorCount.getOrDefault(cube.color, 0) + 1);
        }
        return colorCount;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // зчитуємо кубики з файлу
        List<Cube> cubes = readCubesFromFile("src/Home/HW5/cubes.txt");

        // введіть розмір ребра кубика
        System.out.print("Введіть розмір кубика: ");
        int inputSize = scanner.nextInt();

        // шукаємо кубики з введеним розміром
        List<Cube> sizeCubes = findCubesBySize(cubes, inputSize);

        // записуємо кубикт з потрібним розміром у файл
        String sizeFileName = "src/Home/HW5/cubes_size_" + inputSize + ".txt";
        BufferedWriter sizeWriter = new BufferedWriter(new FileWriter(sizeFileName));
        if (sizeCubes.isEmpty()) {
            sizeWriter.write("Кубиків з ребром " + inputSize + " см не знайдено.");
        } else {
            for (Cube cube : sizeCubes) {
                sizeWriter.write(cube.toString());
                sizeWriter.newLine();
            }
        }
        sizeWriter.close();
        System.out.println("Результат за розміром записано у файл: " + sizeFileName);

        // Підрахунок кубиків за кольорами
        Map<String, Integer> colorCounts = countCubesByColor(cubes);

        // Запис підрахунку за кольорами у файл
        String colorFileName = "src/Home/HW5/cubes_color_count.txt";
        BufferedWriter colorWriter = new BufferedWriter(new FileWriter(colorFileName));
        for (String color : colorCounts.keySet()) {
            colorWriter.write(color + ": " + colorCounts.get(color));
            colorWriter.newLine();
        }
        colorWriter.close();
        System.out.println("Підрахунок кубиків за кольорами записано у файл: " + colorFileName);

        scanner.close();
    }
}
