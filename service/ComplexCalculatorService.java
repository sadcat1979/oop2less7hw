package src.service;

import src.log.ComplexCalculatorLog;
import src.model.ComplexNumber;

public class ComplexCalculatorService {

    private final ComplexCalculatorLog logger = new ComplexCalculatorLog();

    public ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        logger.log("Суммируем " + a + " и " + b);
        ComplexNumber res = new ComplexNumber(a.getRealPart() + b.getRealPart(), a.getImaginaryPart() + b.getImaginaryPart());
        logger.log("Результат " + res);
        return res;
    }

    public ComplexNumber mul(ComplexNumber a, ComplexNumber b) {
        logger.log("Умножаем " + a + " и " + b);
        double multReal = a.getRealPart() * b.getRealPart() - a.getImaginaryPart() * b.getImaginaryPart();
        double mutlImaginary = a.getRealPart() * b.getImaginaryPart() + a.getImaginaryPart() * b.getRealPart();
        ComplexNumber res = new ComplexNumber(multReal, mutlImaginary);
        logger.log("Результат " + res);
        return res;
    }

    public ComplexNumber div(ComplexNumber a, ComplexNumber b) {
        logger.log("Делим " + a + " на " + b);
        double divDenominator = b.getRealPart() * b.getRealPart() + b.getImaginaryPart() * b.getImaginaryPart();
        if (divDenominator == 0) {
            logger.log("Обнаружена попытка деления на ноль!");
            return null;
        }
        double divReal = (a.getRealPart() * b.getRealPart() + a.getImaginaryPart() * b.getImaginaryPart()) / divDenominator;
        double divImaginary = (a.getImaginaryPart() * b.getRealPart() - a.getRealPart() * b.getImaginaryPart()) / divDenominator;
        ComplexNumber res = new ComplexNumber(divReal, divImaginary);
        logger.log("Результат " + res);
        return res;
    }

    public ComplexNumber sub(ComplexNumber a, ComplexNumber b) {
        logger.log("Вычитаем " + b + " из " + a);
        ComplexNumber res = new ComplexNumber(a.getRealPart() - b.getRealPart(), a.getImaginaryPart() - b.getImaginaryPart());
        logger.log("Результат " + res);
        return res;
    }
}
