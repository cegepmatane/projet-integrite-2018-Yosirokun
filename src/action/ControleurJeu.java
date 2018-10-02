package action;

import donnee.JeuDAO;
import donnee.StudioDAO;
import modele.Jeu;
import vue.*;


public class ControleurJeu {
    private static ControleurJeu instance = null;
    private JeuDAO accesseurJeu;
    private StudioDAO accesseurStudio;
    private NavigateurDeVue navigateur;
    private VueListeJeu vueListeJeu;
    private VueJeu vueJeu;
    private VueAjouterJeu vueAjouterJeu;
    private VueModifierJeu vueModifierJeu;

    private ControleurJeu() {

        this.accesseurJeu = JeuDAO.getInstance();
        this.accesseurStudio = StudioDAO.getInstance();
    }

    //instance singleton
    public static ControleurJeu getInstance() {
        if (null == instance) {
            instance = new ControleurJeu();
        }
        return instance;
    }

    public void activerVues(NavigateurDeVue navigateur) {
        this.navigateur = navigateur;
        this.vueAjouterJeu = navigateur.getVueAjouterJeu();
        this.vueJeu = navigateur.getVueJeu();
        this.vueModifierJeu = navigateur.getVueModifierJeu();
        this.vueListeJeu = navigateur.getVueListeJeu();
        this.vueListeJeu.afficherListeJeu(accesseurJeu.listerJeu());
        this.navigateur.naviguerVueListeJeu();
    }

    public void notifierAjouterJeu() {
        Jeu jeu = this.navigateur.getVueAjouterJeu().demanderJeu();
        this.accesseurJeu.ajouterJeu(jeu);
        this.vueListeJeu.afficherListeJeu(this.accesseurJeu.listerJeu());
        this.navigateur.naviguerVueListeJeu();
    }


    public void notifierEnregisterJeu() {
        Jeu jeu = this.navigateur.getVueModifierJeu().demandeJeu();
        this.accesseurJeu.modifierJeu(jeu);
        this.vueListeJeu.afficherListeJeu(this.accesseurJeu.listerJeu());
        this.navigateur.naviguerVueListeJeu();
    }

    public void notifierNaviguerModifierJeu(int idJeu) {
        this.vueModifierJeu.afficherJeu(this.accesseurJeu.repporterJeu(idJeu));
        this.vueModifierJeu.afficherListeStudio(this.accesseurStudio.simulerListeStudio());
        this.navigateur.naviguerVueModifier();
    }

    public void notifierNaviguerAjouterJeu() {
        this.navigateur.naviguerVueAjouterJeu();
    }
}
