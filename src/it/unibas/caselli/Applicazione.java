package it.unibas.caselli;

import it.unibas.caselli.controllo.ControlloMenu;
import it.unibas.caselli.controllo.ControlloPrincipale;
import it.unibas.caselli.modello.Modello;
import it.unibas.caselli.persistenza.DAOArchivio;
import it.unibas.caselli.persistenza.IDAOArchivio;
import it.unibas.caselli.vista.Frame;
import it.unibas.caselli.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {
    
    private static Applicazione singleton = new Applicazione();
    
    private Applicazione() {};
    
    public static Applicazione getIstance() {
        return singleton;
    }
    
    private Modello modello;
    private IDAOArchivio daoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private VistaPrincipale vistaPrincipale;
    private Frame frame;
    
    private void inizializza() {
        this.modello = new Modello();
        daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getIstance().inizializza();            }
        });
    }
}
