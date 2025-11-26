public class OperacionResta {

    private double num1;
    private double num2;
    private double num3;

    public OperacionResta(double num1, double num2, double num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public double calcular() {
        return num1 - num2 - num3;
    }
}