package donnee;

import modele.Jeu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JeuDAO {
    public List<Jeu> simulerListeJeu()
    {
        List<Jeu> listeJeu = new ArrayList<>();
        listeJeu.add(new Jeu("Death stranding", "un jeu de Hideo Kojima"));
        listeJeu.add(new Jeu("Forza horizon 4", "Un nouveau jeu de course marqué Microsoft"));
        return listeJeu;
    }

    private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
    private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/bergerie";
    private static String BASEDEDONNEES_USAGER = "postgres";
    private static String BASEDEDONNEES_MOTDEPASSE = "test";
    private Connection connection = null;
    public static JeuDAO instance = null;

    public JeuDAO()
    {
        try {
            Class.forName(BASEDEDONNEES_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JeuDAO getInstance()
    {
        if(null == instance)
        {
            instance = new JeuDAO();
        }
        return instance;
    }

    //TODO faire toute les methode vide
    public List<Jeu>listerJeu()
    {
        return null;
    }

    public void ajouterJeu(Jeu jeu)
    {

    }
    public void modifierJeu(Jeu jeu)
    {

    }





}
