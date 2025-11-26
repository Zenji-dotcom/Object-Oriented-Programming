package Actividad1.DulceHogar;

public class CompraPanaderia {

    private double importe;

    public CompraPanaderia(double importe) {
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }

    public double getPorcentajeDescuento() {
        if (importe < 100) {
            return 0.0;
        } else if (importe <= 500) {
            return 0.10; // 10%
        } else {
            return 0.15; // 15%
        }
    }

    public double calcularDescuento() {
        return importe * getPorcentajeDescuento();
    }

    public double calcularTotal() {
        return importe - calcularDescuento();
    }
}
