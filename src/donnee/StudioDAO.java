package donnee;

import modele.Studio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudioDAO implements StudioSQL {
    private Connection connection;
    private static StudioDAO instance = null;

    public StudioDAO() {
        connection = BaseDeDonnees.getInstance().getConnection();
    }

    //singleton
    public static StudioDAO getInstance() {
        if (null == instance)
            instance = new StudioDAO();
        return instance;
    }

    public List<Studio> listerStudio(int idJeu) {
        List<Studio> listeStudio = new ArrayList<>();
        try {
            PreparedStatement requeteListerStudio = connection.prepareStatement(SQL_LISTER_STUDIO);
            requeteListerStudio.setInt(1, idJeu);
            ResultSet curseurListeStudio = requeteListerStudio.executeQuery();

            while (curseurListeStudio.next()) {
                int id = curseurListeStudio.getInt("id");
                String nom = curseurListeStudio.getString("nom");
                String description = curseurListeStudio.getString("description");

                Studio studio = new Studio(nom, description);
                studio.setId(id);
                listeStudio.add(studio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeStudio;
    }

    //test sans sql
    public List<Studio> simulerListeStudio() {
        List<Studio> listeStudio = new ArrayList<>();
        Studio studio = new Studio("Bethesda ", "studio responsable des jeu comme les es et dooms");
        listeStudio.add(studio);
        studio = new Studio("Havok", "souvent associer a plusieur studio, est responsable de moteurs graphique");
        listeStudio.add(studio);
        return listeStudio;

    }

}
