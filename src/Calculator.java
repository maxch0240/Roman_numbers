import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("итоговый результат не должен превышать 3999");

        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = sc.nextLine();

        //Определяем арифметическое действие:
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия, завершаем программу
        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
        }

        String[] numbers = exp.split(regexActions[actionIndex]);

        //Определяем формат
        int a, b;
        if (Converter.isRoman(numbers[0])) {
            a = Converter.ToInteger(numbers[0]);
        } else {
            a = Integer.parseInt(numbers[0]);
        }
        if (Converter.isRoman(numbers[1])) {
            b = Converter.ToInteger(numbers[1]);
        } else {
            b = Integer.parseInt(numbers[1]);
        }

        //арифметические вычисления
        int result = switch (actions[actionIndex]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
        System.out.println("Результат:");
        System.out.println(result);
        System.out.println(Converter.toRoman(result));
    }
}