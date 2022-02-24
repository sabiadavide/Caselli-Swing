package it.unibas.caselli.vista;

import it.unibas.caselli.modello.Casello;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaCasello extends AbstractTableModel {

    private List<Casello> listaCaselli = new ArrayList<>();

    public List<Casello> getListaCaselli() {
        return listaCaselli;
    }

    public void setListaCaselli(List<Casello> listaCaselli) {
        this.listaCaselli = listaCaselli;
    }
    
    @Override
    public int getRowCount() {
        return this.listaCaselli.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Casello casello = this.listaCaselli.get(rowIndex);
        if (columnIndex == 0) {
            return casello.getCodiceUnivoco();
        } else if (columnIndex == 1) {
            return casello.getNomeAutostrada();
        } else if (columnIndex == 2) {
            return casello.getPosizione();
        } else if (columnIndex == 3) {
            return casello.getListaAccessi().size();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice";
        } else if (column == 1) {
            return "Autostrada";
        } else if (column == 2) {
            return "Posizione(Km)";
        } else if (column == 3) {
            return "Lista accessi";
        }
        return "";
    }

    public void inizializzaTabella() {
        this.fireTableDataChanged();
    }
    
}
