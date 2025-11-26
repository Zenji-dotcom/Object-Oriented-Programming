package Actividad1.DulceHogar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDulceHogar extends JFrame {

    private JTextField txtImporte;
    private JLabel lblImporte;
    private JLabel lblDescuento;
    private JLabel lblTotal;

    public PanelDulceHogar() {
        setTitle("Panadería Dulce Hogar - Cálculo de Descuento");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Campo de entrada
        add(new JLabel("Importe de la compra:"));
        txtImporte = new JTextField();
        add(txtImporte);

        JButton btnCalcular = new JButton("Calcular descuento");
        add(btnCalcular);

        // Espacio vacío para acomodar el grid
        add(new JLabel(""));

        // Reporte
        add(new JLabel("Importe:"));
        lblImporte = new JLabel("-");
        add(lblImporte);

        add(new JLabel("Descuento aplicado:"));
        lblDescuento = new JLabel("-");
        add(lblDescuento);

        add(new JLabel("Total a pagar:"));
        lblTotal = new JLabel("-");
        add(lblTotal);

        // Acción del botón
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
    }

    private void calcular() {
        try {
            double importe = Double.parseDouble(txtImporte.getText());

            if (importe < 0) {
                JOptionPane.showMessageDialog(this,
                        "El importe no puede ser negativo.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Clase
            CompraPanaderia compra = new CompraPanaderia(importe);

            double descuento = compra.calcularDescuento();
            double total = compra.calcularTotal();
            double porcentaje = compra.getPorcentajeDescuento() * 100;

            lblImporte.setText(String.format("$ %.2f", importe));
            lblDescuento.setText(String.format("$ %.2f (%.0f%%)", descuento, porcentaje));
            lblTotal.setText(String.format("$ %.2f", total));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Ingresa un importe válido (solo números).",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelDulceHogar ventana = new PanelDulceHogar();
            ventana.setVisible(true);
        });
    }
}

