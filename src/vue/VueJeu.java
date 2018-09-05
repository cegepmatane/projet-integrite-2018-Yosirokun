package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Jeu;

public class VueJeu extends Application {
    protected Label valeurNom;
    protected Label valeurDescription;
    private Object afficherJeu;


    @Override
    public void start(Stage stage) throws Exception {
        Pane panneau = new Pane();
        GridPane grilleJeu = new GridPane();

        valeurNom = new Label("");
        grilleJeu.add(new Label("Nom: "),0,0);
        grilleJeu.add(valeurNom, 1, 0);

        valeurDescription = new Label("");
        grilleJeu.add(new Label("Description: "),0,1);
        grilleJeu.add(valeurDescription, 1, 1);

        panneau.getChildren().add(grilleJeu);
        stage.setScene(new Scene(panneau, 400, 400));
        stage.show();

        //pour tester

        Jeu jeu = new Jeu("Fallout 76", "un jeu trop bien!");
        this.afficherJeu(jeu);
    }

    private void afficherJeu(Jeu jeu) {
        this.valeurNom.setText(jeu.getNom());
        this.valeurDescription.setText(jeu.getDescription());

    }
}
