package Actividad1.Multiplicacion;

public class OperacionMultiplicacion {

    private double num1;
    private double num2;

    public OperacionMultiplicacion(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double calcular() {
        return num1 * num2;
    }
}
