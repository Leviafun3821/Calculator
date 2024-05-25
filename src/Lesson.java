import java.util.Scanner;

public class Lesson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result;
        char operator;

        System.out.print("Введите данные в формате \"Число1 - выражение - Число2 и нажмите Enter\": ");
        String input = scanner.nextLine(); // Получаем всю строку без разделения

        try {
            String[] parts = input.split(" ");

            if (parts.length > 3) {
                System.out.println("Ошибка формата! Через пробел - два числа и один оператор (+, -, *, /)");
                return;
            }

            int number1 = Integer.parseInt(parts[0]); // Первое число
            operator = parts[1].charAt(0); // Оператор
            int number2 = Integer.parseInt(parts[2]); // Второе число

            // Проверяем, что числа находятся в диапазоне от 1 до 10
            if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) {
                System.out.println("Ошибка! Числа должны быть в диапазоне от 1 до 10.");
                return;
            }

            switch (operator) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                        result = number1 / number2;
                    break;
                default:
                    System.out.println("Ошибка! Введена неверная арифметическая операция.");
                    return;
            }
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Неверный формат ввода. Через пробел: число-оператор-число и Enter");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка - данный формат не является математической операцией.");
        }
    }
}