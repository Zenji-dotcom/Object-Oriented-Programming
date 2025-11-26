package Actividad1.Division;

public class OperacionDivision {

    private double numerador;
    private double denominador;

    public OperacionDivision(double numerador, double denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public double calcular() {
        if (denominador == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return numerador / denominador;
    }
}
