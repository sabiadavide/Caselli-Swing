package it.unibas.caselli.persistenza;

import it.unibas.caselli.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String msg) throws DAOException;
}
