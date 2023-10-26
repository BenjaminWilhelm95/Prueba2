package model.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Jugador;
import model.Seleccion;
public class DBconecctor {
    private Connection connection;

    public DBconecctor() {
        try {

            String url = "jdbc:mysql://localhost:3306/super_campeones";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);

            crearTablas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearTablas() {
        try {
            String createSeleccionesTable = "CREATE TABLE IF NOT EXISTS selecciones (id INT AUTO_INCREMENT PRIMARY KEY, nombre_pais VARCHAR(255), ranking_fifa INT)";
            String createJugadoresTable = "CREATE TABLE IF NOT EXISTS jugadores (id INT AUTO_INCREMENT PRIMARY KEY, numero INT, nombre_jugador VARCHAR(255), posicion VARCHAR(255), id_seleccion INT)";

            try (PreparedStatement createSeleccionesStatement = connection.prepareStatement(createSeleccionesTable);
                 PreparedStatement createJugadoresStatement = connection.prepareStatement(createJugadoresTable)) {
                createSeleccionesStatement.execute();
                createJugadoresStatement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarJugador(Jugador jugador) {
        try {
            String sql = "INSERT INTO jugadores (numero, nombre_jugador, posicion, id_seleccion) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, jugador.getNumero());
            statement.setString(2, jugador.getNombreJugador());
            statement.setString(3, jugador.getPosicion());
            statement.setInt(4, jugador.getIdSeleccion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todas las selecciones de la base de datos
    public List<Seleccion> obtenerSelecciones() {
        List<Seleccion> selecciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM selecciones";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Seleccion seleccion = new Seleccion(resultSet.getInt("id"), resultSet.getString("nombre_pais"), resultSet.getInt("ranking_fifa"));
                selecciones.add(seleccion);
            }
      } catch (SQLException e) {
          e.printStackTrace();
      }
       return selecciones;
  }

    // Obtener jugadores de una selección específica
    public List<Jugador> obtenerJugadoresPorSeleccion(int idSeleccion) {
        List<Jugador> jugadores = new ArrayList<>();
        try {
            String sql = "SELECT * FROM jugadores WHERE id_seleccion = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idSeleccion);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Jugador jugador = new Jugador(resultSet.getInt("numero"), resultSet.getString("nombre_jugador"), resultSet.getString("posicion"), resultSet.getInt("id_seleccion"));
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }
    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//    public void agregarJugador(Jugador jugador) {
//        try {
//            String sql = "INSERT INTO jugadores (numero, nombre_jugador, posicion, id_seleccion) VALUES (?, ?, ?, ?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, jugador.getNumero());
//            statement.setString(2, jugador.getNombreJugador());
//            statement.setString(3, jugador.getPosicion());
//            statement.setInt(4, jugador.getIdSeleccion());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Obtener todas las selecciones de la base de datos
//    public List<Seleccion> obtenerSelecciones() {
//        List<Seleccion> selecciones = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM selecciones";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Seleccion seleccion = new Seleccion(resultSet.getInt("id"), resultSet.getString("nombre_pais"), resultSet.getInt("ranking_fifa"));
//                selecciones.add(seleccion);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return selecciones;
//    }
//
//    // Obtener jugadores de una selección específica
//    public List<Jugador> obtenerJugadoresPorSeleccion(int idSeleccion) {
//        List<Jugador> jugadores = new ArrayList<>();
//        try {
//            String sql = "SELECT * FROM jugadores WHERE id_seleccion = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, idSeleccion);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                Jugador jugador = new Jugador(resultSet.getInt("numero"), resultSet.getString("nombre_jugador"), resultSet.getString("posicion"), resultSet.getInt("id_seleccion"));
//                jugadores.add(jugador);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return jugadores;
//    }