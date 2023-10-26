package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame {
    public VentanaMenu() {
        super("Menú de Super Campeones Cup 2023");

        JButton agregarSeleccionButton = new JButton("Agregar Selección");
        JButton buscarSeleccionButton = new JButton("Buscar Selección");
        JButton mostrarSeleccionButton = new JButton("Mostrar Selecciones");

        agregarSeleccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaAgregarSeleccion();
            }
        });

        buscarSeleccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaBuscarSeleccion();
            }
        });

        mostrarSeleccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaMostrarSeleccion();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(agregarSeleccionButton);
        panel.add(buscarSeleccionButton);
        panel.add(mostrarSeleccionButton);

        Container container = getContentPane();
        container.add(panel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaMenu();
            }
        });
    }
}
