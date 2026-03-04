package asptt.toulouse;

public class FeedBack {
    private Membre membre;       
    private Evenement evenement; 
    private String commentaire;  
    private int evaluation;      

    
    public FeedBack(Membre membre, Evenement evenement, String commentaire, int evaluation) {
        this.membre = membre;
        this.evenement = evenement;
        setCommentaire(commentaire);
        setEvaluation(evaluation);
    }

    
    public String getCommentaire() {
        return commentaire;
    }

    
    public void setCommentaire(String commentaire) {
        if (commentaire != null && !commentaire.isEmpty()) {
            this.commentaire = commentaire;
        } else {
            System.out.println("Le commentaire ne peut pas être vide.");
        }
    }

    
    public int getEvaluation() {
        return evaluation;
    }

    
    public void setEvaluation(int evaluation) {
        if (evaluation >= 1 && evaluation <= 5) {
            this.evaluation = evaluation;
        } else {
            System.out.println("L'évaluation doit être entre 1 et 5.");
        }
    }

    
    public void afficherFeedBack() {
        System.out.println("Feedback de " + membre.getNom() + " " + membre.getPrenom());
        System.out.println("Événement : " + evenement.getNom());
        System.out.println("Commentaire : " + commentaire);
        System.out.println("Évaluation : " + evaluation + "/5");
    }
}
