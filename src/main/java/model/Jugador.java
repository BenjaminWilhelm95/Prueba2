package model;
public class Jugador {
    private int numero;
    private String nombreJugador;
    private String posicion;
    private int idSeleccion;

    public Jugador(int numero, String nombreJugador, String posicion, int idSeleccion) {
        this.numero = numero;
        this.nombreJugador = nombreJugador;
        this.posicion = posicion;
        this.idSeleccion = idSeleccion;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNombreJugador() {
        return nombreJugador;
    }
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public int getIdSeleccion() {
        return idSeleccion;
    }
    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }
}
