import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите запрос: пример'2 + 2'");

        String input = sc.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат:" + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static String calc(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            return "Неправильный ввод. Используйте: 'a оператор b'.";
        }

        try {
            int a = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int b = Integer.parseInt(parts[2]);

            if (a < 1 || a > 10 || b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            }
            int result;

            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    return "Неизвестный оператор. используейте: +, -, *, /.";
            }
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            return "Ошибка: введите целые числа.";
        }
    }
}
