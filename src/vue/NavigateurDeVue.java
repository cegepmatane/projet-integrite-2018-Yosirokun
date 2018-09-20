package vue;

import action.ControleurJeu;
import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDeVue extends Application {

    private Stage stade;

    private VueListeJeu vueListeJeu = null;
    private VueAjouterJeu vueAjouterJeu = null;
    private VueJeu vueJeu = null;
    private VueModifierJeu vueModifierJeu = null;
    protected ControleurJeu controleur;

    public NavigateurDeVue() {
        this.vueAjouterJeu = new VueAjouterJeu();
        this.vueJeu = new VueJeu();
        this.vueListeJeu = new VueListeJeu();
        this.vueModifierJeu = new VueModifierJeu();
        this.controleur = ControleurJeu.getInstance();
        this.controleur.activerVues(this);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stade = primaryStage;

        this.stade.setScene(null);
        this.stade.show();

        this.vueModifierJeu.setControleur(this.controleur);
        this.vueAjouterJeu.setControleur(this.controleur);
        this.vueJeu.setControleur(this.controleur);
        this.vueListeJeu.setControleur(this.controleur);

        naviguerVueListeJeu();



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
