package donnee;

import modele.Jeu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JeuDAO implements JeuSQL{
    public List<Jeu> simulerListeJeu()
    {
        List<Jeu> listeJeu = new ArrayList<>();
        listeJeu.add(new Jeu("Death stranding", "un jeu de Hideo Kojima"));
        listeJeu.add(new Jeu("Forza horizon 4", "Un nouveau jeu de course marqué Microsoft"));
        return listeJeu;
    }


    private Connection connection = null;
    public static JeuDAO instance = null;

    public JeuDAO()
    {
       this.connection = BaseDeDonnees.getInstance().getConnection();
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
            ResultSet curseurListeJeux = requeteListeJeux.executeQuery(SQL_LISTER_JEU);
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
            PreparedStatement requeteAjouterJeu = connection.prepareStatement(SQL_AJOUTER_JEU);
            requeteAjouterJeu.setString(1, jeu.getNom());
            requeteAjouterJeu.setString(2, jeu.getDescription());
            requeteAjouterJeu.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifierJeu(Jeu jeu)
    {
        try {
            PreparedStatement requeteModifierJeu = connection.prepareStatement(SQL_MODIFIER_JEU);
            requeteModifierJeu.setString(1, jeu.getNom());
            requeteModifierJeu.setString(2, jeu.getDescription());
            requeteModifierJeu.setInt(3, jeu.getId());


            requeteModifierJeu.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
