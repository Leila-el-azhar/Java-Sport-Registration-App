package asptt.toulouse;

public class NotificationEvenement extends Notification {
    private Evenement evenement;

    public NotificationEvenement(Membre membre, Evenement evenement) {
        super(membre);
        this.evenement = evenement;
    }

    @Override
    public void envoyer() {
        
        String message = "Notification : " + membre.getNom() + " " + membre.getPrenom() +
                         ", vous êtes inscrit(e) à l'événement : " + evenement.getNom() +
                         " qui se tiendra le " + evenement.getDate() + ".";
        envoyerEmailSimule(membre.getEmail(), "Inscription à l'événement", message);
    }

    
    private void envoyerEmailSimule(String emailDestinataire, String sujet, String message) {
        System.out.println("Envoi simulé d'email à : " + emailDestinataire);
        System.out.println("Sujet : " + sujet);
        System.out.println("Message : " + message);
    }
}

