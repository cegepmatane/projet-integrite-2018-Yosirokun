package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDeVue extends Application {

    private Stage stade;

    private VueListeJeu vueListeJeu = null;
    private VueAjouterJeu vueAjouterJeu = null;
    private VueJeu vueJeu = null;
    private VueModifierJeu vueModifierJeu = null;

    public NavigateurDeVue() {
        this.vueAjouterJeu = new VueAjouterJeu();
        this.vueJeu = new VueJeu();
        this.vueListeJeu = new VueListeJeu();
        this.vueModifierJeu = new VueModifierJeu();
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

    public VueModifierJeu getVueModifierJeu() {
        return vueModifierJeu;
    }

    public void naviguerVueJeu() {
        stade.setScene(this.vueJeu);
        stade.show();
    }

    public void naviguerVueAjouterJeu() {
        stade.setScene(this.vueAjouterJeu);
        stade.show();
    }

    public void naviguerVueListeJeu() {
        stade.setScene(this.vueListeJeu);
        stade.show();
    }
    public void naviguerVueModifier()
    {
        stade.setScene(this.vueModifierJeu);
        stade.show();
    }
}
