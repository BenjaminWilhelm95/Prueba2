package gui;
import model.Jugador;
import model.data.DBconecctor;
import model.Seleccion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class VentanaBuscarSeleccion extends JFrame {
    private JComboBox<Seleccion> seleccionComboBox;
    private JTextArea jugadoresTextArea;

    private DBconecctor db;

    public VentanaBuscarSeleccion() {
        super("Buscar Selección y Jugadores");
        db = new DBconecctor();

        seleccionComboBox = new JComboBox<>();
        jugadoresTextArea = new JTextArea(10, 30);
        jugadoresTextArea.setEditable(false);

        JButton buscarButton = new JButton("Buscar Jugadores");

        List<Seleccion> selecciones = db.obtenerSelecciones();
        for (Seleccion seleccion : selecciones) {
            seleccionComboBox.addItem(seleccion);
        }

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Seleccion seleccion = (Seleccion) seleccionComboBox.getSelectedItem();
                if (seleccion != null) {
                    List<Jugador> jugadores = db.obtenerJugadoresPorSeleccion(seleccion.getId());
                    mostrarJugadores(jugadores);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(seleccionComboBox);
        panel.add(buscarButton);

        JScrollPane scrollPane = new JScrollPane(jugadoresTextArea);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarJugadores(List<Jugador> jugadores) {
        jugadoresTextArea.setText("");
        for (Jugador jugador : jugadores) {
            jugadoresTextArea.append("Número: " + jugador.getNumero() + ", Nombre: " + jugador.getNombreJugador() + ", Posición: " + jugador.getPosicion() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaBuscarSeleccion();
            }
        });
    }
}
