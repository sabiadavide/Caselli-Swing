package it.unibas.caselli.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private List<Casello> listaCaselli = new ArrayList<>();

    public List<Casello> getListaCaselli() {
        return listaCaselli;
    }

    public void setListaCaselli(List<Casello> listaCaselli) {
        this.listaCaselli = listaCaselli;
    }

    public void aggiungiCasello(Casello casello) {
        this.listaCaselli.add(casello);
    }

    public List<Casello> cercaPerAutostrada(String autostrada) {
        List<Casello> listaFiltrata = new ArrayList<>();
        for (Casello casello : this.listaCaselli) {
            if (casello.getNomeAutostrada().equalsIgnoreCase(autostrada)) {
                listaFiltrata.add(casello);
            }
        }
        return listaFiltrata;
    }
    
    public boolean isCaselloSuccessivo(Casello altroCasello) {
        for (Casello casello : this.listaCaselli) {
            if (casello.getPosizione() > altroCasello.getPosizione()) {
                if (casello.getListaAccessi().size() <= altroCasello.getListaAccessi().size()) {
                    return true;
                }
            }
        }
        return false;
    }
}
