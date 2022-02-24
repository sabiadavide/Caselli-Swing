package it.unibas.caselli.controllo;

import it.unibas.caselli.Applicazione;
import it.unibas.caselli.modello.Archivio;
import it.unibas.caselli.modello.Costanti;
import it.unibas.caselli.persistenza.DAOException;
import it.unibas.caselli.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {
    private Action azioneEsci = new AzioneEsci();
    
    private Action azioneCarica = new AzioneCarica();
    
    
    public Action getAzioneEsci() {
        return this.azioneEsci;
    }
    
    public Action getAzioneCarica() {
        return this.azioneCarica;
    }
    
    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
    
    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica Archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getIstance().getDaoArchivio();
            try {
                Archivio archivo = daoArchivio.carica("");
                Applicazione.getIstance().getModello().putBeans(Costanti.ARCHIVIO, archivo);
                Applicazione.getIstance().getFrame().getMessaggio("Caricato correttamente l'archivio contenente " + archivo.getListaCaselli().size() + " caselli");
                Applicazione.getIstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerifica().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVerificaPagamento().setEnabled(true);
            } catch (DAOException exception) {
                Applicazione.getIstance().getFrame().getErrore("Impossibile carticare l'archivio");
            }
        }
    }
}
