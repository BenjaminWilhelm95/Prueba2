package controller;
import java.util.List;
import model.Jugador;
import model.Seleccion;
import model.data.DBconecctor;

public class SeleccionController {
    public static void main(String[] args) {
        DBconecctor db = new DBconecctor();
        Seleccion seleccion1 = new Seleccion("Argentina", 5);
        Seleccion seleccion2 = new Seleccion("Brasil", 3);

        db.agregarSeleccion(seleccion1);
        db.agregarSeleccion(seleccion2);

        Jugador jugador1 = new Jugador(10, "Lionel Messi", "Delantero", seleccion1.getId());
        Jugador jugador2 = new Jugador(9, "Neymar Jr.", "Delantero", seleccion2.getId());

        db.agregarJugador(jugador1);
        db.agregarJugador(jugador2);

        List<Seleccion> selecciones = db.obtenerSelecciones();
        List<Jugador> jugadores = db.obtenerJugadoresPorSeleccion(seleccion1.getId());

        for (Seleccion seleccion : selecciones) {
            System.out.println("Selección: " + seleccion.getNombrePais() + ", Ranking FIFA: " + seleccion.getRankingFIFA());
        }

        for (Jugador jugador : jugadores) {
            System.out.println("Jugador: " + jugador.getNombreJugador() + ", Posición: " + jugador.getPosicion());
        }

        db.cerrarConexion();
    }
}
