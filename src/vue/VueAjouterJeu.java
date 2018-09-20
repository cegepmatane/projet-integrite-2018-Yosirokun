package vue;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueAjouterJeu extends Scene {




    public VueAjouterJeu() {
        super(new GridPane(), 400, 40);
        GridPane grilleAjouter = (GridPane) this.getRoot();
        TextField texteNom = new TextField();
        TextField texteDescription = new TextField();
        Button btnConfirmer = new Button("Confirmer");
        //le bonton est seulement pour l'estétique pour l'instant
        grilleAjouter.add(new Label("Nom: "),0, 0);
        grilleAjouter.add(texteNom, 1, 0);
        grilleAjouter.add(new Label("Description: "), 0,1);
        grilleAjouter.add(texteDescription,1,1);

        grilleAjouter.add(btnConfirmer, 1,2);



    }
}
