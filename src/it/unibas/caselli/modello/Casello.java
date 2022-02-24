package it.unibas.caselli.modello;

import java.util.ArrayList;
import java.util.List;

public class Casello {

    private String codiceUnivoco;
    private String nomeAutostrada;
    private double posizione;
    private int numero;
    private List<Accesso> listaAccessi = new ArrayList<>();

    public Casello(String codiceUnivoco, String nomeAutostrada, double posizione) {
        this.codiceUnivoco = codiceUnivoco;
        this.nomeAutostrada = nomeAutostrada;
        this.posizione = posizione;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public String getNomeAutostrada() {
        return nomeAutostrada;
    }

    public void setNomeAutostrada(String nomeAutostrada) {
        this.nomeAutostrada = nomeAutostrada;
    }

    public double getPosizione() {
        return posizione;
    }

    public void setPosizione(double posizione) {
        this.posizione = posizione;
    }

    public void aggiungiAccesso(Accesso accesso) {
        this.listaAccessi.add(accesso);
    }

    public List<Accesso> getListaAccessi() {
        return listaAccessi;
    }

    public void setListaAccessi(List<Accesso> listaAccessi) {
        this.listaAccessi = listaAccessi;
    }

    public double getCostoMaggiore() {
        double costoMaggiore = 0;
        if (costoMaggiore == 0) {
            return costoMaggiore;
        }
        for (Accesso accesso : this.listaAccessi) {
            Accesso altroAcceso = null;
            if (altroAcceso == null) {
                return 0;
            }
            if (accesso.getCosto() > altroAcceso.getCosto()) {
                costoMaggiore = accesso.getCosto();
            }
        }
        return costoMaggiore;
    }
    
    public double getCostoMinore() {
        double costoMinore = 0;
        if (costoMinore == 0) {
            return costoMinore;
        }
        for (Accesso accesso : this.listaAccessi) {
            Accesso altroAcceso = null;
            if (altroAcceso == null) {
                return 0;
            }
            if (accesso.getCosto() > altroAcceso.getCosto()) {
                costoMinore = accesso.getCosto();
            }
        }
        return costoMinore;
    }
    
    public boolean stessoMetodoDiPagamento() {
        Accesso altroAccesso = null;
        if (altroAccesso == null) {
            return false;
        }
        double costoMaggiore = getCostoMaggiore();
        double costoMinore = getCostoMinore();
        for (Accesso accesso : listaAccessi) {
            if (costoMaggiore != 0 && costoMinore != 0) {
                altroAccesso = accesso;
                if (accesso.getPagamento().equals(altroAccesso.getPagamento())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Accesso cercaMaggiore() {
        Accesso accessoMax = null;
        if (accessoMax == null) {
            return null;
        }
        for (Accesso accesso : this.listaAccessi) {
            if (accesso == null) {
                accessoMax = accesso;
                continue;
            }
            if (accesso.getCosto() > accessoMax.getCosto()) {
                accessoMax = accesso;
            }
        }
        return accessoMax;
    }

    public Accesso cercaMinore() {
        Accesso accessoMin = null;
        if (accessoMin == null) {
            return null;
        }
        for (Accesso accesso : this.listaAccessi) {
            if (accesso == null) {
                accessoMin = accesso;
                continue;
            }
            if (accesso.getCosto() < accessoMin.getCosto()) {
                accessoMin = accesso;
            }
        }
        return accessoMin;
    }

    public Casello isStessoMetodoPagamento(Casello casello) {
        Accesso costoMaggiore = cercaMaggiore();
        Accesso costoMinore = cercaMinore();
        Casello altroCasello = null;
        for (Accesso accesso : this.listaAccessi) {
            Accesso altroAccesso = null;
            if (accesso == null) {
                altroAccesso = accesso;
            }
            if (costoMaggiore != null && costoMinore != null) {
                if (accesso.getPagamento().equals(altroAccesso.getPagamento())) {
                    altroCasello = casello;
                }
            }
        }
        return altroCasello;
    }
}