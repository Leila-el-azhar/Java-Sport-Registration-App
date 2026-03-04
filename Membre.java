package asptt.toulouse;

public class Membre extends Personne {
    private int id;
    private String email;
    private String numeroCarte;

    
    public Membre(int id, String nom, String prenom, String email, String numeroCarte) {
        super(nom, prenom); 
        this.id = id; //identifiant unique 
        this.email = email;
        this.numeroCarte = numeroCarte;
    }

    
    @Override
    public String afficherRole() {
        return "Membre de l'association";
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

   
    @Override
    public String toString() {
        return "Membre{id=" + id +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", email='" + email + '\'' +
                ", numeroCarte='" + numeroCarte + '\'' +
                ", role='" + afficherRole() + '\'' +
                '}';
    }
}