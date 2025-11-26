package Actividad1.Division;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDivision extends JFrame {

    private JTextField txtNum1;
    private JTextField txtNum2;
    private JLabel lblResultado;

    public PanelDivision() {
        setTitle("División de 2 números - POO");
        setSize(320, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Numerador:"));
        txtNum1 = new JTextField();
        add(txtNum1);

        add(new JLabel("Denominador:"));
        txtNum2 = new JTextField();
        add(txtNum2);

        JButton btnCalcular = new JButton("Dividir");
        add(btnCalcular);

        lblResultado = new JLabel("Resultado: ");
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularDivision();
            }
        });
    }

    private void calcularDivision() {
        try {
            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());

            OperacionDivision op = new OperacionDivision(n1, n2);
            double resultado = op.calcular();

            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingresa solo números válidos.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error matemático",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelDivision ventana = new PanelDivision();
            ventana.setVisible(true);
        });
    }
}
