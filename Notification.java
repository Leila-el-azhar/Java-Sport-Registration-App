package asptt.toulouse;

public abstract class Notification {
    protected Membre membre;

    public Notification(Membre membre) {
        this.membre = membre;
    }

    public abstract void envoyer();
}


