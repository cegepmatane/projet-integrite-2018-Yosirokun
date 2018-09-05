package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueAjouterJeu extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane panneau = new Pane();
        GridPane grilleAjouter = new GridPane();
        TextField texteNom = new TextField();
        TextField texteDescription = new TextField();
        Button btnConfirmer = new Button("Confirmer");
        //le bonton est seulement pour l'estétique pour l'instant
        grilleAjouter.add(new Label("Nom: "),0, 0);
        grilleAjouter.add(texteNom, 1, 0);
        grilleAjouter.add(new Label("Description: "), 0,1);
        grilleAjouter.add(texteDescription,1,1);

        grilleAjouter.add(btnConfirmer, 1,2);
        panneau.getChildren().add(grilleAjouter);

        stage.setScene(new Scene(panneau, 400, 400));
        stage.show();

    }
}
