package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueListeJeu extends Scene {

    public VueListeJeu() {
        super(new GridPane(), 400, 400);
        GridPane grilleJeux = (GridPane) this.getRoot();


    }
}
