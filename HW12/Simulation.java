package Home.HW12;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Simulation {
    public static void main(String[] args) throws IOException {
        String fileName;
        if (args.length > 0) {
            fileName = args[0];
        } else {
            fileName = "src/Home/HW12/input01.txt";
        }

        List<String> lines = Files.readAllLines(Paths.get(fileName));
        if (lines.size() < 3) {
            System.out.println("NO");
            return;
        }

        String direction = lines.get(0).trim();
        int requiredCredits = Integer.parseInt(lines.get(1).trim());
        int initialMoney = Integer.parseInt(lines.get(2).trim());

        Student student;
        if (direction.equals("humanitarian")) {
            student = new HumanitarianStudent(initialMoney, requiredCredits);
        } else if (direction.equals("natural")) {
            student = new NaturalStudent(initialMoney, requiredCredits);
        } else {
            student = new MixedStudent(initialMoney, requiredCredits);
        }

        for (int i = 3; i < lines.size(); i++) {
            if (student.isExpelled()) {
                break;
            }

            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String command = parts[0];

            if (command.equals("teach")) {
                if (parts.length < 2) {
                    continue;
                }
                String discType = parts[1];
                int credits;
                if (parts.length >= 3) {
                    credits = Integer.parseInt(parts[2]);
                } else {
                    if (discType.equals("humanitarian")) {
                        credits = 3;
                    } else if (discType.equals("natural")) {
                        credits = 5;
                    } else {
                        credits = 0;
                    }
                }
                TeachVisitor visitor = new TeachVisitor(discType, credits);
                student.accept(visitor);
            } else if (command.equals("obtain")) {
                if (parts.length < 3) {
                    continue;
                }
                int amount = Integer.parseInt(parts[2]);
                String kind = parts[1];
                if (kind.equals("scholarship")) {
                    ScholarshipVisitor visitor = new ScholarshipVisitor(amount);
                    student.accept(visitor);
                } else {
                    ParentMoneyVisitor visitor = new ParentMoneyVisitor(amount);
                    student.accept(visitor);
                }
            } else if (command.equals("pay")) {
                if (parts.length < 3) {
                    continue;
                }
                int amount = Integer.parseInt(parts[2]);
                String what = parts[1];
                if (what.equals("hostel")) {
                    PayHostelVisitor visitor = new PayHostelVisitor(amount);
                    student.accept(visitor);
                } else {
                    PayFoodVisitor visitor = new PayFoodVisitor(amount);
                    student.accept(visitor);
                }
            } else if (command.equals("get")) {
                if (parts.length < 2) {
                    continue;
                }
                int amount = Integer.parseInt(parts[1]);
                ParentMoneyVisitor visitor = new ParentMoneyVisitor(amount);
                student.accept(visitor);
            }
        }

        if (!student.isExpelled() && student.getCredits() >= student.getRequiredCredits()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
