package asptt.toulouse;

public class Evenement {
    private String nom;                 
    private String date;                
    private int capaciteMax;            
    private int placesDisponibles;      
    private float prixNonAdherent;      
    private Membre[] participants;      

   
    public Evenement(String nom, String date, int capaciteMax, float prixNonAdherent) {
        this.nom = nom;
        this.date = date;
        this.capaciteMax = capaciteMax;
        this.placesDisponibles = capaciteMax;  
        this.prixNonAdherent = prixNonAdherent;
        this.participants = new Membre[capaciteMax]; 
    }
    
    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }
    
    public Membre[] getParticipants() {
        return participants;
    }


    
    public void inscrireMembre(Membre membre, Adhesion adhesion) {
        if (!adhesion.estAdherent()) { 
            System.out.println("Échec de l'inscription pour " + membre.getNom() + " " + membre.getPrenom() 
                               + ": Vous n'êtes pas encore inscrit car votre paiement d'adhésion est en attente.");
            return;
        }
        if (placesDisponibles > 0) {
            participants[capaciteMax - placesDisponibles] = membre; 
            placesDisponibles--;
            System.out.println(membre.getNom() + " " + membre.getPrenom() + " s'est inscrit gratuitement à l'événement " + nom + ".");
        } else {
            System.out.println("Il n'y a plus de places disponibles pour l'événement " + nom + ".");
        }
    }

   
    public void inscrireNonAdherent(Membre membre, float paiement) {
        if (placesDisponibles > 0) {
            if (paiement >= prixNonAdherent) {
                participants[capaciteMax - placesDisponibles] = membre; 
                placesDisponibles--;
                System.out.println(membre.getNom() + " " + membre.getPrenom() + " s'est inscrit à l'événement " + nom + " en tant que non-adhérent, paiement reçu.");
            } else {
                System.out.println("Paiement insuffisant pour " + membre.getNom() + " " + membre.getPrenom() + ". Le paiement requis est de " + prixNonAdherent + " euros.");
            }
        } else {
            System.out.println("Il n'y a plus de places disponibles pour l'événement " + nom + ".");
        }
    }

    
    public void afficherDetails() {
        System.out.println("Événement : " + nom);
        System.out.println("Date : " + date);
        System.out.println("Places disponibles : " + placesDisponibles + "/" + capaciteMax);
        System.out.println("Prix pour les non-adhérents : " + prixNonAdherent + " euros");
        System.out.println("Participants inscrits :");
        for (int i = 0; i < capaciteMax - placesDisponibles; i++) {
            Membre membre = participants[i];
            if (membre != null) {
                System.out.println(membre.getNom() + " " + membre.getPrenom());
            }
        }
    }
}
