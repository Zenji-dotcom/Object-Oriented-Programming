package Actividad1.Multiplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMultiplicacion extends JFrame {

    private JTextField txtNum1;
    private JTextField txtNum2;
    private JLabel lblResultado;

    public PanelMultiplicacion() {
        setTitle("Multiplicación de 2 números - POO");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Número 1:"));
        txtNum1 = new JTextField();
        add(txtNum1);

        add(new JLabel("Número 2:"));
        txtNum2 = new JTextField();
        add(txtNum2);

        JButton btnCalcular = new JButton("Multiplicar");
        add(btnCalcular);

        lblResultado = new JLabel("Resultado: ");
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMultiplicacion();
            }
        });
    }

    private void calcularMultiplicacion() {
        try {
            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());

            // Usamos la clase POO
            OperacionMultiplicacion op = new OperacionMultiplicacion(n1, n2);
            double resultado = op.calcular();

            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingresa solo números válidos.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelMultiplicacion ventana = new PanelMultiplicacion();
            ventana.setVisible(true);
        });
    }
}
