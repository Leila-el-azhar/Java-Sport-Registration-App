package asptt.toulouse;

public class Test {
    public static void main(String[] args) {
        
        Membre membre1 = new Membre(1, "Dupont", "Jean", "jean.dupont@example.com", "CARTE12345");
        Membre membre2 = new Membre(2 , "Leila", "Elazhar", "leilazhar@exemple.com","CARTE1235");
        
        System.out.println("Informations du membre :");
        System.out.println(membre1);
        System.out.println(membre2);

        
        Adhesion adhesion1 = new Adhesion(membre1, 120.0f, "01/01/2024", true);  // Adhésion annuelle
        Adhesion adhesion2 = new Adhesion(membre2, 50.0f, "01/01/2024", false);  // Adhésion mensuelle

        
        System.out.println("Avant paiement :");
        adhesion1.afficherAdhesion();
        adhesion2.afficherAdhesion();

        
        System.out.println("\nTentative de paiement:");
        adhesion1.payerAdhesion(120.0f);  // Paiement suffisant
        adhesion2.payerAdhesion(40.0f);   // Paiement insuffisant

        
        System.out.println("\nAprès paiement :");
        adhesion1.afficherAdhesion();
        adhesion2.afficherAdhesion();
        
        
        Evenement evenement = new Evenement("Tournoi de Tennis", "15/01/2024", 10, 30.0f);

        
        evenement.inscrireMembre(membre1, adhesion1);  // Inscription gratuite 
        evenement.inscrireNonAdherent(membre2, 30.0f); // Inscription payante 

        
        evenement.afficherDetails();
        
        System.out.println("\nParticipants inscrits à l'événement : " + evenement.getNom());
        Membre[] participants = evenement.getParticipants();
        for (Membre participant : participants) {
            if (participant != null) { 
                System.out.println("- " + participant.getNom() + " " + participant.getPrenom());
            }
        }
     
        System.out.println("\nNotifications pour les paiements :");
        Notification notifPaiement1 = new NotificationPaiement(membre1, adhesion1);
        Notification notifPaiement2 = new NotificationPaiement(membre2, adhesion2);
        notifPaiement1.envoyer();
        notifPaiement2.envoyer();

        
        System.out.println("\nEnvoi des notifications pour les participants à l'événement :");
        GestionnaireNotifications gestionnaire = new GestionnaireNotifications();
        gestionnaire.notifierParticipants(evenement);
        
        Membre membre3 = new Membre(3, "Dupont", "Jean", "jean.dupont@example.com", "123456");
        Evenement evenement2 = new Evenement("Course de Noël", "25/12/2024", 100, 10.0f);

        
        FeedBack feedback = new FeedBack(membre3, evenement2, "Événement très bien organisé, j'ai adoré !", 5);

        feedback.afficherFeedBack();

    }
}




