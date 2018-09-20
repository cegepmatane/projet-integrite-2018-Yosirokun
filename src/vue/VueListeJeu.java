package vue;

import action.ControleurJeu;
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
            numero++;
            this.grilleJeux.add(new Label(jeu.getNom()),0, numero);
            this.grilleJeux.add(new Label(jeu.getDescription()),1,numero);

        }
    }

    public ControleurJeu getControleur() {
        return controleur;
    }

    public void setControleur(ControleurJeu controleur) {
        this.controleur = controleur;
    }
}
