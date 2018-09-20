package vue;

import action.ControleurJeu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Jeu;

public class VueJeu extends Scene {
    protected Label valeurNom;
    protected Label valeurDescription;
    protected ControleurJeu Controleur = null;

    public ControleurJeu getControleur() {
        return Controleur;
    }

    public void setControleur(ControleurJeu controleur) {
        Controleur = controleur;
    }

    public VueJeu() {
        super(new GridPane(), 400, 400);

        GridPane grilleJeu = (GridPane) this.getRoot();

        valeurNom = new Label("");
        grilleJeu.add(new Label("Nom: "), 0, 0);
        grilleJeu.add(valeurNom, 1, 0);

        valeurDescription = new Label("");
        grilleJeu.add(new Label("Description: "), 0, 1);
        grilleJeu.add(valeurDescription, 1, 1);


        //pour tester

        Jeu jeu = new Jeu("Fallout 76", "un jeu trop bien!");
        this.afficherJeu(jeu);
    }

    //TODO Enlever la methode de test de jeu
    private void afficherJeu(Jeu jeu) {
        this.valeurNom.setText(jeu.getNom());
        this.valeurDescription.setText(jeu.getDescription());

    }
}
