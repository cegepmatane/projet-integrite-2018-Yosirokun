package action;

import donnee.JeuDAO;
import vue.NavigateurDeVue;
import vue.VueAjouterJeu;
import vue.VueJeu;
import vue.VueListeJeu;


public class ControleurJeu {
    private NavigateurDeVue navigateur;
    private VueListeJeu vueListeJeu;
    private VueJeu vueJeu;
    private VueAjouterJeu vueAjouterJeu;
    private static ControleurJeu instance = null;

    JeuDAO accesseurJeu = null;

    private ControleurJeu()
    {
        this.accesseurJeu = JeuDAO.getInstance();
    }

    //instance singleton
    public static ControleurJeu getInstance()
    {
        if(null == instance)
        {
            instance = new ControleurJeu();
        }
        return instance;
    }

    public void activerVues (NavigateurDeVue navigateur)
    {
        this.navigateur = navigateur;
        this.vueAjouterJeu = navigateur.getVueAjouterJeu();
        this.vueJeu = navigateur.getVueJeu();
        this.vueListeJeu = navigateur.getVueListeJeu();
    }






}
