package asptt.toulouse;

public class GestionnaireNotifications {
    public void notifierParticipants(Evenement evenement) {
        System.out.println("Envoi des notifications aux participants de l'événement : " + evenement.getNom());
        Membre[] participants = evenement.getParticipants();
        for (Membre participant : participants) {
            if (participant != null) {
                Notification notification = new NotificationEvenement(participant, evenement);
                notification.envoyer();
            }
        }
    }

    public void notifierPaiement(Adhesion adhesion) {
        Membre membre = adhesion.getMembre();
        Notification notification = new NotificationPaiement(membre, adhesion);
        notification.envoyer();
    }
}
