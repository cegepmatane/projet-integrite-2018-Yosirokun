package vue;

import action.ControleurJeu;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class VueListeJeu extends Scene {
    protected ControleurJeu controleur = null;

    public VueListeJeu() {
        super(new GridPane(), 400, 400);
        GridPane grilleJeux = (GridPane) this.getRoot();


    }

    public ControleurJeu getControleur() {
        return controleur;
    }

    public void setControleur(ControleurJeu controleur) {
        this.controleur = controleur;
    }
}
