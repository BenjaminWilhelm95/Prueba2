package gui;
import model.Seleccion;
import model.data.DBconecctor;
import model.Jugador;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaMostrarSeleccion extends JFrame {
    private JTextArea seleccionTextArea;
    private DBconecctor db;

    public VentanaMostrarSeleccion() {
        super("Mostrar Selecciones y Jugadores");
        db = new DBconecctor();

        seleccionTextArea = new JTextArea(20, 40);
        seleccionTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(seleccionTextArea);

        List<Seleccion> selecciones = db.obtenerSelecciones();
        mostrarSeleccionesYJugadores(selecciones);

        Container container = getContentPane();
        container.add(scrollPane);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarSeleccionesYJugadores(List<Seleccion> selecciones) {
        seleccionTextArea.setText("");
        for (Seleccion seleccion : selecciones) {
            seleccionTextArea.append("Selección: " + seleccion.getNombrePais() + ", Ranking FIFA: " + seleccion.getRankingFIFA() + "\n");

            List<Jugador> jugadores = db.obtenerJugadoresPorSeleccion(seleccion.getId());
            for (Jugador jugador : jugadores) {
                seleccionTextArea.append("  Jugador: " + jugador.getNombreJugador() + ", Posición: " + jugador.getPosicion() + "\n");
            }
            seleccionTextArea.append("\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaMostrarSeleccion();
            }
        });
    }
}
