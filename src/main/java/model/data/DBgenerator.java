package model.data;
import model.Jugador;
import model.Seleccion;
public class DBgenerator {
    public static void main(String[] args) {
        DBconecctor db = new DBconecctor();

        db.crearTablas();

        db.agregarSeleccion(new Seleccion("Argentina", 5));
        db.agregarSeleccion(new Seleccion("Brasil", 3));
        db.agregarSeleccion(new Seleccion("España", 6));

        // Agregar jugadores de ejemplo
        db.agregarJugador(new Jugador(1, "Lionel Messi", "Delantero", 1));
        db.agregarJugador(new Jugador(10, "Neymar Jr.", "Delantero", 2));
        db.agregarJugador(new Jugador(7, "Sergio Ramos", "Defensa", 3));

        // Cerrar la conexión a la base de datos
        db.cerrarConexion();
    }
}
