package vue;

import action.ControleurJeu;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modele.Jeu;

public class VueAjouterJeu extends Scene {
    protected ControleurJeu controleur = null;
    TextField texteNom;
    TextField texteDescription;

    public ControleurJeu getControleur() {
        return controleur;
    }

    public void setControleur(ControleurJeu controlleur) {
        this.controleur = controlleur;
    }

    public VueAjouterJeu() {
        super(new GridPane(), 400, 40);
        GridPane grilleAjouter = (GridPane) this.getRoot();
        this.texteNom = new TextField();
        this.texteDescription = new TextField();
        Button btnConfirmer = new Button("Confirmer");
        //le bonton est seulement pour l'estétique pour l'instant
        grilleAjouter.add(new Label("Nom: "), 0, 0);
        grilleAjouter.add(texteNom, 1, 0);
        grilleAjouter.add(new Label("Description: "), 0, 1);
        grilleAjouter.add(texteDescription, 1, 1);

        grilleAjouter.add(btnConfirmer, 1, 2);

    }
    public Jeu demanderJeu()
    {
        Jeu jeu = new Jeu(this.texteNom.getText(), this.texteDescription.getText());
        return jeu;
    }
}
