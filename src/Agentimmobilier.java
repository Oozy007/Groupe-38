public class Agentimmobilier {
    public Agentimmobilier(String nom, String prenom, int numeroAgent, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroAgent = numeroAgent;
        this.email = email;
    }

    private String nom;
    private String prenom;
    private int numeroAgent;
    private String email;
    
    public String getEmail() {
    return email;
}

    public void setEmail(String email) {
    this.email = email;
}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumeroAgent() {
        return numeroAgent;
    }

    public void setNumeroAgent(int numeroAgent) {
        this.numeroAgent = numeroAgent;
    }
}