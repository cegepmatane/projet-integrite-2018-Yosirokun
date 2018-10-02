package vue;

import action.ControleurJeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Jeu;

public class VueAjouterJeu extends Scene {
    protected ControleurJeu controleur = null;
    TextField texteNom;
    TextField texteDescription;
    protected Button btnConfirmer;

    public VueAjouterJeu() {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleAjouter = new GridPane();
        this.texteNom = new TextField();
        this.texteDescription = new TextField();

        
        this.btnConfirmer = new Button("Confirmer");
        btnConfirmer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controleur.notifierAjouterJeu();
            }
        });

        grilleAjouter.add(new Label("Nom: "), 0, 0);
        grilleAjouter.add(texteNom, 1, 0);

        grilleAjouter.add(new Label("Description: "), 0, 1);
        grilleAjouter.add(texteDescription, 1, 1);

        panneau.getChildren().add(new Label("Ajouter un jeu"));
        panneau.getChildren().add(grilleAjouter);
        panneau.getChildren().add(btnConfirmer);

    }

    public Jeu demanderJeu() {
        Jeu jeu = new Jeu(this.texteNom.getText(), this.texteDescription.getText());
        return jeu;
    }

    public ControleurJeu getControleur() {
        return controleur;
    }

    public void setControleur(ControleurJeu controlleur) {
        this.controleur = controlleur;
    }
}