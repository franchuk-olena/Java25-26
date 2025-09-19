package Home.HW1;

public class B01_03 {

    public static void main(String[] args) {
        int product = 1;

        for (int i = 0; i < args.length; i++) {
            try {
                int num = Integer.parseInt(args[i]);
                product *= num;
            } catch (NumberFormatException e) {
                System.out.printf("Аргумент \"%s\" не є цілим числом%n", args[i]);
                return;
            }
        }

        System.out.printf("Добуток аргументів: %d%n", product);
    }
}
