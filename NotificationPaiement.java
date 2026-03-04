package asptt.toulouse;

public class NotificationPaiement extends Notification {
    private Adhesion adhesion;

    public NotificationPaiement(Membre membre, Adhesion adhesion) {
        super(membre);
        this.adhesion = adhesion;
    }

    @Override
    public void envoyer() {
        
        String message;
        if (!adhesion.estAdherent()) {
            message = "Rappel : " + membre.getNom() + " " + membre.getPrenom() +
                      ", veuillez régler votre adhésion de " + adhesion.getMontant() + " euros.";
        } else {
            message = "Le membre " + membre.getNom() + " " + membre.getPrenom() +
                      " est à jour pour son adhésion.";
        }

        envoyerEmailSimule(membre.getEmail(), "Rappel paiement adhésion", message);
    }

    
    private void envoyerEmailSimule(String emailDestinataire, String sujet, String message) {
        System.out.println("Envoi simulé d'email à : " + emailDestinataire);
        System.out.println("Sujet : " + sujet);
        System.out.println("Message : " + message);
    }
}

