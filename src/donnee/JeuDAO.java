package donnee;

import modele.Jeu;

import java.sql.*;
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
    private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/jeu_interessant";
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


    public List<Jeu>listerJeu()
    {
        List<Jeu> listeJeux = new ArrayList<>();
        Statement requeteListeJeux;

        try {
            requeteListeJeux = connection.createStatement();
            ResultSet curseurListeJeux = requeteListeJeux.executeQuery("SELECT * FROM jeu");
            while (curseurListeJeux.next())
            {
                int id = curseurListeJeux.getInt("id");
                String nom = curseurListeJeux.getString("nom");
                String description = curseurListeJeux.getString("description");
                Jeu jeu = new Jeu(nom, description);
                jeu.setId(id);
                listeJeux.add(jeu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeJeux;
    }

    public void ajouterJeu(Jeu jeu)
    {
        try {
            Statement requeteAjouterJeu = connection.createStatement();
            String requeteSqlAjouter = "INSERT INTO jeu(nom, description) VALUES('"+ jeu.getNom() + "','"+jeu.getDescription()+"')";
            requeteAjouterJeu.execute(requeteSqlAjouter);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifierJeu(Jeu jeu)
    {
        try {
            Statement requeteModifierJeu = connection.createStatement();

            String sqlModifier = "UPDATE jeu SET nom = '" + jeu.getNom() + "', description = '" + jeu.getDescription() + "' WHERE id = " + jeu.getId();
            requeteModifierJeu.execute(sqlModifier);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
