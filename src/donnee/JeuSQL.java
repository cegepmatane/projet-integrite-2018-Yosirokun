package donnee;

public interface JeuSQL {
    String SQL_LISTER_JEU = "SELECT * FROM jeu";
    String SQL_AJOUTER_JEU = "INSERT INTO jeu(nom, description) VALUES(?,?)";
    String SQL_MODIFIER_JEU = "UPDATE jeu SET nom = ? , description = ? WHERE id = ?";
    String SQL_RAPPORTER_JEU = "SELECT * FROM jeu WHERE id = ?";

}
