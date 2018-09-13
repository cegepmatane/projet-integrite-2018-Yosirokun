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


public class VueModifierJeu extends Scene {
    protected TextField valeurNom;
    protected TextField valeurDescription;

    private ControleurJeu controleur = null;
    protected Button actionEnregisterChangement;

    private int idJeu;


    public VueModifierJeu() {
        super(new VBox(), 400, 400);
        VBox panneau = (VBox) this.getRoot();
        GridPane grilleMouton = new GridPane();
        this.actionEnregisterChangement = new Button("Enregistrer");

        this.actionEnregisterChangement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO notifier Enregistrer Jeu dans le controlleur
            }
        });
        valeurNom = new TextField();
        grilleMouton.add(new Label("Nom : "), 0, 0);
        grilleMouton.add(valeurNom, 1, 0);

        valeurDescription = new TextField("");
        grilleMouton.add(new Label("Couleur : "), 0, 1);
        grilleMouton.add(valeurDescription, 1, 1);
    }
    public void afficherJeu(Jeu jeu)
    {
        this.idJeu = jeu.getId();
        this.valeurNom.setText(jeu.getNom());
        this.valeurDescription.setText(jeu.getDescription());
    }

    public Jeu demandeJeu()
    {
        Jeu jeu = new Jeu(this.valeurNom.getText(), this.valeurDescription.getText());
        jeu.setId(this.idJeu);

        return jeu;
    }

    public void setControleur(ControleurJeu controleur) {
        this.controleur = controleur;
    }
}
