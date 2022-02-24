package it.unibas.caselli.controllo;

import it.unibas.caselli.Applicazione;
import it.unibas.caselli.modello.Archivio;
import it.unibas.caselli.modello.Casello;
import it.unibas.caselli.modello.Costanti;
import it.unibas.caselli.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();
    private Action azioneVerifica = new AzioneVerifica();
    private Action azioneVerificaPagamento = new AzioneVerificaPagamento();

    public Action getAzioneCerca() {
        return this.azioneCerca;
    }

    public Action getAzioneVerifica() {
        return this.azioneVerifica;
    }

    public Action getAzioneVerificaPagamento() {
        return this.azioneVerificaPagamento;
    }

    private class AzioneVerificaPagamento extends AbstractAction {

        public AzioneVerificaPagamento() {
        this.putValue(NAME, "Verifica pagamento");
            this.putValue(SHORT_DESCRIPTION, "Verifica se l’accesso più costoso e quello meno costoso sono stati effettuati con\n" +
"lo stesso tipo di pagamento");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Seleziona prima un casello");
                return;
            }
            List<Casello> listaFiltrata = (List<Casello>) Applicazione.getIstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Casello casello = listaFiltrata.get(rigaSelezionata);
            boolean verifica = casello.stessoMetodoDiPagamento();
            if (verifica) {
                Applicazione.getIstance().getFrame().getMessaggio("NO");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("SI");
            }
        }   
    }
    
    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica se l'accesso piu costroso e meno costoso sono stati effettuati con lo stesso tipo di pagamento");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Seleziona prima un casello");
                return;
            }
            List<Casello> listaFiltrata = (List<Casello>) Applicazione.getIstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Casello casello = listaFiltrata.get(rigaSelezionata);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(Costanti.ARCHIVIO);
            boolean verifica = archivio.isCaselloSuccessivo(casello);
            if (verifica) {
                Applicazione.getIstance().getFrame().getMessaggio("Tutti i caselli successivi in quell’autostrada hanno almeno lo stesso\n"
                        + "numero di accessi");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("Tutti i caselli successivi in quell’autostrada NON hanno almeno lo stesso\n"
                        + "numero di accessi");
            }
            /*
            Casello altroCasello = archivio.verificaCaselliSuccessivi(casello);
            if (altroCasello == null) {
                Applicazione.getIstance().getFrame().getMessaggio("Tutti i caselli successivi in quell’autostrada NON hanno almeno lo stesso\n" +
"numero di accessi");
            } else {
                Applicazione.getIstance().getFrame().getMessaggio("Tutti i caselli successivi in quell’autostrada hanno almeno lo stesso\n" +
"numero di accessi");
            } 
             */
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca caselli per autostrada");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String autostrada = vista.getCampoTesto();
            String convalida = errori(autostrada);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Casello> listaFiltrata = archivio.cercaPerAutostrada(autostrada);
            if (listaFiltrata.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio("Non risulta nessun casello nel sistema");
                return;
            }
            Applicazione.getIstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

    }

    private String errori(String a) {
        StringBuilder sb = new StringBuilder();
        if (a.trim().isEmpty()) {
            sb.append("Immettere un autostrada per continuare\n");
        }
        return sb.toString();
    }
}
