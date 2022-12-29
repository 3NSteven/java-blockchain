public class Offre {
    private final Acheteur acheteur;
    private final double prix;
    private final Enchere enchere;

    public Offre(Enchere enchere, Acheteur acheteur, double prix){
        this.enchere = enchere;
        this.acheteur = acheteur;
        this.prix = prix;
    }

    public double getPrix() {
        return prix;
    }
}
