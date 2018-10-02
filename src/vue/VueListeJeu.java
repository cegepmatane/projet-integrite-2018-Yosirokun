package vue;

import action.ControleurJeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import modele.Jeu;

import java.util.List;

public class VueListeJeu extends Scene {
    protected ControleurJeu controleur = null;
    protected Button actionNaviguerVueAjouter;
    GridPane grilleJeux = null;


    public VueListeJeu() {
        super(new GridPane(), 400, 400);
        grilleJeux = (GridPane) this.getRoot();
        this.actionNaviguerVueAjouter = new Button("Ajouter un jeu");


    }

    public void afficherListeJeu(List<Jeu> listeJeu)
    {
        this.grilleJeux.getChildren().clear();
        int numero = 0;
        this.grilleJeux.add(new Label("nom"),0, numero);
        this.grilleJeux.add(new Label("description"), 1, numero);
        for(Jeu jeu : listeJeu)
        {
            Button btnModifierJeu = new Button("Modifier");
            btnModifierJeu.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controleur.notifierNaviguerModifierJeu(jeu.getId());
                }
            });
            numero++;
            this.grilleJeux.add(new Label(jeu.getNom()),0, numero);
            this.grilleJeux.add(new Label(jeu.getDescription()),1,numero);
            this.grilleJeux.add(btnModifierJeu, 2, numero);
        }
        this.actionNaviguerVueAjouter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public  void handle(ActionEvent event) {
                controleur.notifierNaviguerAjouterJeu();
            }
        });
        this.grilleJeux.add(actionNaviguerVueAjouter, 1, ++numero);
    }

    public void setControleur(ControleurJeu controleur) {
        this.controleur = controleur;
    }
}
