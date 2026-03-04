package asptt.toulouse;

public abstract class Personne {
    private String nom;
    private String prenom;

    
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    
    public abstract String afficherRole();

    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    
    @Override
    public String toString() {
        return "Personne{nom='" + nom + "', prenom='" + prenom + "'}";
    }
}