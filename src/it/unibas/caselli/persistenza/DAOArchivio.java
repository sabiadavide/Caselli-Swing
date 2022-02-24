package it.unibas.caselli.persistenza;

import it.unibas.caselli.modello.Accesso;
import it.unibas.caselli.modello.Archivio;
import it.unibas.caselli.modello.Casello;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String msg) throws DAOException {
        Archivio archivio = new Archivio();
        Casello casello0 = new Casello("AD128", "Autostrada A1", 7.8); //no
        Casello casello1 = new Casello("AD127", "Autostrada A1", 8.1); //no
        Casello casello2 = new Casello("AB123", "Autostrada A15", 6.1);
        Casello casello3 = new Casello("A2345", "Autostrada A1", 9.0); //si
        Casello casello4 = new Casello("BC456", "Autostrada A156", 7.1);

        casello0.aggiungiAccesso(new Accesso("GJL234K", "Ferrari", 8, "Carta")); 
        casello1.aggiungiAccesso(new Accesso("KLP121334", "Ferrari", 100, "Carta")); 
        casello1.aggiungiAccesso(new Accesso("FG895JK", "Fiat", 8, "Contanti")); 
        casello2.aggiungiAccesso(new Accesso("FL123GH", "Fiat", 9, "Contanti"));
        casello2.aggiungiAccesso(new Accesso("FL123GH", "Fiat", 9, "Contanti"));
        casello3.aggiungiAccesso(new Accesso("GJL234K", "Ferrari", 8, "Carta")); 
        casello3.aggiungiAccesso(new Accesso("KLP121334", "Ferrari", 100, "Carta")); 
        casello4.aggiungiAccesso(new Accesso("FP156JL", "Ferrari", 10, "Bancomat"));

        archivio.aggiungiCasello(casello0);
        archivio.aggiungiCasello(casello1);
        archivio.aggiungiCasello(casello2);
        archivio.aggiungiCasello(casello3);
        archivio.aggiungiCasello(casello4);

        return archivio;
    }
}
