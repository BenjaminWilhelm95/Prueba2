package gui;
import model.data.DBconecctor;
import model.Seleccion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarSeleccion extends JFrame {
    private JTextField nombrePaisField;
    private JTextField rankingFIFAField;

    private DBconecctor db;

    public VentanaAgregarSeleccion() {
        super("Agregar Selección");
        db = new DBconecctor();

        JLabel nombrePaisLabel = new JLabel("Nombre del País:");
        JLabel rankingFIFALabel = new JLabel("Ranking FIFA:");

        nombrePaisField = new JTextField(20);
        rankingFIFAField = new JTextField(10);

        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePais = nombrePaisField.getText();
                String rankingFIFAText = rankingFIFAField.getText();

                try {
                    int rankingFIFA = Integer.parseInt(rankingFIFAText);

                    Seleccion nuevaSeleccion = new Seleccion(nombrePais, rankingFIFA);
                    db.agregarSeleccion(nuevaSeleccion);

                    JOptionPane.showMessageDialog(null, "Selección agregada exitosamente.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ranking FIFA debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(nombrePaisLabel);
        panel.add(nombrePaisField);
        panel.add(rankingFIFALabel);
        panel.add(rankingFIFAField);
        panel.add(agregarButton);

        Container container = getContentPane();
        container.add(panel);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaAgregarSeleccion();
            }
        });
    }
}
