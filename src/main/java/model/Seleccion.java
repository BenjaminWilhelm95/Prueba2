package model;
public class Seleccion {
    private int id;
    private String nombrePais;
    private int rankingFIFA;

    public Seleccion(int id, String nombrePais, int rankingFIFA) {
        this.id = id;
        this.nombrePais = nombrePais;
        this.rankingFIFA = rankingFIFA;
    }
    public Seleccion(String nombrePais, int rankingFIFA) {
        this.nombrePais = nombrePais;
        this.rankingFIFA = rankingFIFA;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }
}
