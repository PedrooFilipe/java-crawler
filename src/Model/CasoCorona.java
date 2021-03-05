package Model;

import java.util.Date;


public class CasoCorona {

    private int id;
    private int confirmados;
    private int suspeitos;
    private int recuperados;
    private int obitos;
    private Date dataPesquisa;

    public CasoCorona() {
    }

    public CasoCorona(int confirmados, int suspeitos, int recuperados, int obitos, Date dataPesquisa) {
        this.confirmados = confirmados;
        this.suspeitos = suspeitos;
        this.recuperados = recuperados;
        this.obitos = obitos;
        this.dataPesquisa = dataPesquisa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConfirmados() {
        return confirmados;
    }

    public void setConfirmados(int confirmados) {
        this.confirmados = confirmados;
    }

    public int getSuspeitos() {
        return suspeitos;
    }

    public void setSuspeitos(int suspeitos) {
        this.suspeitos = suspeitos;
    }

    public int getRecuperados() {
        return recuperados;
    }

    public void setRecuperados(int recuperados) {
        this.recuperados = recuperados;
    }

    public int getObitos() {
        return obitos;
    }

    public void setObitos(int obitos) {
        this.obitos = obitos;
    }

    public Date getDataPesquisa() {
        return dataPesquisa;
    }

    public void setDataPesquisa(Date dataPesquisa) {
        this.dataPesquisa = dataPesquisa;
    }
}