import java.util.Scanner;

public class Lesson {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите два числа (между ними математическое выражение) и нажмите ENTER: ");
            String expression = scanner.nextLine();
            try {
                System.out.println(parse(expression));
            }catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка! В вашем примере допущено неверное выражение");
            }
        }

        public static String parse (String expression) throws Exception {
            int num1, num2;
            String oper, result;
            String[] operands = expression.split("[+\\-*/]");
            if(operands.length == 3) throw new Exception("Ошибка! Должно быть два операнда и математическое выражение");
            oper = detectOperation(expression);
            if(oper == null) throw new Exception("Ошибка, неподдерживаемая математическая операция");
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) throw new Exception("Числа должны быть от 1 до 10");
            int arabian = calc(num1, num2, oper);
            result = String.valueOf(arabian);
            return result;
        }

        static String detectOperation(String expression) {
            if(expression.contains("+")) return "+";
            else if (expression.contains("-")) return "-";
            else if (expression.contains("*")) return "*";
            else if (expression.contains("/")) return "/";
            else return null;
        }

        static int calc (int a, int b, String oper) {
            if(oper.equals("+")) return a + b;
            else if (oper.equals("-")) return a - b;
            else if (oper.equals("*")) return a * b;
            else return a / b;
        }
    }