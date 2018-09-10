package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDeVue extends Application {

    private Stage stade;

    private VueListeJeu vueListeJeu = null;
    private VueAjouterJeu vueAjouterJeu = null;
    private VueJeu vueJeu = null;

    public NavigateurDeVue()
    {
        this.vueAjouterJeu = new VueAjouterJeu();
        this.vueJeu = new VueJeu();
        this.vueListeJeu = new VueListeJeu();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stade = primaryStage;

        this.stade.setScene(null);
        this.stade.show();

        //TODO metre le controlleur


    }

    public VueListeJeu getVueListeJeu() {
        return vueListeJeu;
    }

    public VueAjouterJeu getVueAjouterJeu() {
        return vueAjouterJeu;
    }

    public VueJeu getVueJeu() {
        return vueJeu;
    }


}
