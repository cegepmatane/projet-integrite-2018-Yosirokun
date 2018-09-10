package action;

import donnee.JeuDAO;
import vue.NavigateurDeVue;
import vue.VueAjouterJeu;
import vue.VueJeu;
import vue.VueListeJeu;

public class ControleurJeu {
    private NavigateurDeVue navigateur;
    private VueListeJeu vueListeJeu = null;
    private VueJeu vueJeu = null;
    private VueAjouterJeu vueAjouterJeu = null;
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
    }






}
