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
import modele.Studio;

import java.util.List;


public class VueModifierJeu extends Scene {
    protected TextField valeurNom;
    protected TextField valeurDescription;

    private ControleurJeu controleur = null;
    protected Button actionEnregisterChangement;
    protected GridPane grilleListeStudio = new GridPane();
    protected Button actionAjouterStudio;
    protected VBox panneau;

    private int idJeu = 0;


    public VueModifierJeu() {
        super(new VBox(), 400, 400);
        panneau = (VBox) this.getRoot();
        GridPane grilleJeu = new GridPane();
        this.actionAjouterStudio = new Button("Ajouter un studio");
        this.actionEnregisterChangement = new Button("Enregistrer");

        this.actionAjouterStudio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO afficher la vue ajouter studio;
            }
        });

        this.actionEnregisterChangement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controleur.notifierEnregisterJeu();
            }
        });
        valeurNom = new TextField();
        grilleJeu.add(new Label("Nom : "), 0, 0);
        grilleJeu.add(valeurNom, 1, 0);

        valeurDescription = new TextField("");
        grilleJeu.add(new Label("Couleur : "), 0, 1);
        grilleJeu.add(valeurDescription, 1, 1);

        panneau.getChildren().add(new Label("Modifier un jeu"));
        panneau.getChildren().add(grilleJeu);
        panneau.getChildren().add(this.actionEnregisterChangement);

    }

    public void afficherJeu(Jeu jeu) {
        this.idJeu = jeu.getId();
        this.valeurNom.setText(jeu.getNom());
        this.valeurDescription.setText(jeu.getDescription());
    }

    public void afficherListeStudio(List<Studio> listeStudio) {
        int numero = 0;
        for (Studio studio : listeStudio) {
            this.grilleListeStudio.add(new Label(studio.getNom()), 0, numero);
            this.grilleListeStudio.add(new Label(studio.getDescription()),1, numero);
            this.grilleListeStudio.add(new Button("modifier"), 2, numero);
            this.grilleListeStudio.add(new Button("supprimer"), 3, numero);
            numero++;
        }
        panneau.getChildren().add(grilleListeStudio);
        panneau.getChildren().add(actionAjouterStudio);
    }

    public Jeu demandeJeu() {
        Jeu jeu = new Jeu(this.valeurNom.getText(), this.valeurDescription.getText());
        jeu.setId(this.idJeu);

        return jeu;
    }

    public void setControleur(ControleurJeu controleur) {
        this.controleur = controleur;
    }
}
