package modele;

public class Studio {
    protected  int id;
    protected String nom;
    protected String description;

    public Studio(String nom, String description)
    {
        super();
        this.nom = nom;
        this.description = description;

    }

    //section getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
