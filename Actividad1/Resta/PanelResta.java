import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelResta extends JFrame {

    private JTextField txt1, txt2, txt3;
    private JLabel lblResultado;

    public PanelResta() {
        setTitle("Resta de 3 números - Actividad POO");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Número 1:"));
        txt1 = new JTextField();
        add(txt1);

        add(new JLabel("Número 2:"));
        txt2 = new JTextField();
        add(txt2);

        add(new JLabel("Número 3:"));
        txt3 = new JTextField();
        add(txt3);

        JButton btnCalcular = new JButton("Calcular");
        add(btnCalcular);

        lblResultado = new JLabel("Resultado: ");
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResta();
            }
        });
    }

    private void calcularResta() {
        try {
            double a = Double.parseDouble(txt1.getText());
            double b = Double.parseDouble(txt2.getText());
            double c = Double.parseDouble(txt3.getText());

            //Clase
            OperacionResta operacion = new OperacionResta(a, b, c);
            double resultado = operacion.calcular();

            lblResultado.setText("Resultado: " + resultado);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Ingresa solo números.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new PanelResta().setVisible(true);
    }
}
