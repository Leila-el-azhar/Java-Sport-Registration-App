package asptt.toulouse;

public class Adhesion {
    private Membre membre;        
    private boolean isAdherent;   
    private float montant;       
    private String dateDebut;     
    private String dateFin;     

    public Adhesion(Membre membre, float montant, String dateDebut, boolean annuelle) {
        this.membre = membre;
        this.montant = montant;
        this.isAdherent = false; 
        this.dateDebut = dateDebut;
        this.dateFin = calculerDateFin(dateDebut, annuelle);
    }
    public Membre getMembre() {
    	return membre;
    }
    public float getMontant() {
        return montant;
    }
    public void setMontant(float montant) {
        if (montant > 0) {  
            this.montant = montant;
            System.out.println("Le montant de l'adhésion a été mis à jour à : " + montant + " euros.");
        } else {
            System.out.println("Le montant doit être supérieur à zéro.");
        }
    }

    private String calculerDateFin(String dateDebut, boolean annuelle) {
        
        if (annuelle) {
            return "Fin : 1 an après la date de début : " + dateDebut;
        } else {
            return "Fin : 1 mois après la date de début : " + dateDebut;
        }
    }


    
    public boolean estAdherent() {
        return isAdherent;
    }

    
    public void payerAdhesion(float paiement) {
        if (paiement >= montant) {
            isAdherent = true;
            System.out.println("Adhésion réussie pour " + membre.getNom() + " " + membre.getPrenom() + ".");
        } else {
            System.out.println("Paiement insuffisant. L'adhésion nécessite un montant de " + montant + " euros.");
            isAdherent=false;
            dateFin=null;
        }
    }

    
    public String afficherAdhesion() {
        return "Adhésion pour le membre : " + membre.getNom() + " " + membre.getPrenom() + "\n" +
               "État : " + (isAdherent ? "Adhérent" : "Non-adhérent") + "\n" +
               "Montant à payer pour adhésion : " + montant + " euros.\n" +
               "Date de début : " + dateDebut + "\n" +
               "Date de fin : " + dateFin + "\n";
    }

}


