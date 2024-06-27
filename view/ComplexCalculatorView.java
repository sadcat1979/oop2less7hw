package src.view;

import static java.lang.Double.parseDouble;
import java.util.Scanner;
import src.log.ComplexCalculatorLog;
import src.model.ComplexNumber;
import src.service.ComplexCalculatorService;

public class ComplexCalculatorView {

    private final Scanner iScanner = new Scanner(System.in);
    private final ComplexCalculatorLog logger = new ComplexCalculatorLog();

    public void run() {
        logger.log("Старт программы");
        ComplexCalculatorService calcServ = new ComplexCalculatorService();
        ComplexNumber result;
        while (true) {
            result = null;
            ComplexNumber operandA = promptComplex("Введите первый аргумент: ");
            ComplexNumber operandB = promptComplex("Введите первый аргумент: ");

            String command = prompt("Введите действие (+, *, /, -): ");

            switch (command) {
                case "+" ->
                    result = calcServ.add(operandA, operandB);
                case "-" ->
                    result = calcServ.sub(operandA, operandB);
                case "*" ->
                    result = calcServ.mul(operandA, operandB);
                case "/" -> {
                    result = calcServ.div(operandA, operandB);
                    if (result == null) {
                        System.out.println("Обнаружена попытка деления на ноль!");
                    }
                }
                default ->
                    System.out.println("Действие не распознано");
            }

            if (result != null) {
                System.out.println("Результат: " + operandA + " " + command + " " + operandB + " = " + result);
            }

            String isBoring = prompt("Еще посчитать (y/n)? ");
            if (!isBoring.equalsIgnoreCase("Y")) {
                System.out.println("ВсегО хорошегО!");
                logger.log("Выход из программы");
                System.exit(0);
            }
        }
    }

    private String prompt(String msg) {
        System.out.print(msg);
        return iScanner.nextLine();
    }

    private double promptDouble(String msg) {
        double res = 0.0d;
        boolean unSuccessInput = true;
        while (unSuccessInput) {
            System.out.print(msg);
            try {
                res = parseDouble(iScanner.nextLine());
                unSuccessInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Это не вещественное число!");
            }
        }
        return res;
    }

    private ComplexNumber promptComplex(String msg) {
        System.out.println(msg);
        double inputReal = promptDouble("Введите вещественную часть: ");
        double inputImaginary = promptDouble("Введите мнимую часть: ");
        ComplexNumber res = new ComplexNumber(inputReal, inputImaginary);
        logger.log("Ввели комплексное число " + res);
        return res;
    }
}
