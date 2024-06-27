package src.model;

public class ComplexNumber {

    private double realPart = 0.0;
    private double imaginaryPart = 0.0;

    public ComplexNumber() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }

    public ComplexNumber(double realPart) {
        this.realPart = realPart;
        this.imaginaryPart = 0.0;
    }

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public ComplexNumber getCurrentNumber() {
        return new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        if (this.imaginaryPart == 0) {
            return this.realPart + "";
        }
        if (this.realPart == 0) {
            return this.imaginaryPart + "i";
        }
        if (this.imaginaryPart < 0) {
            return this.realPart + " - " + (-this.imaginaryPart) + "i";
        }
        return this.realPart + " + " + this.imaginaryPart + "i";
    }
}
