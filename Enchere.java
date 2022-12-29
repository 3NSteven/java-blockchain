public class Enchere {

    private final Vendeur vendeur;
    private final String nomProduit;
    private int prix;
    private int tempsDepart;
    private int duree;

    public Enchere(Vendeur vendeur, String nomProduit, int prixInitial, int tempsDepart, int duree) {
        this.vendeur = vendeur;
        this.nomProduit = nomProduit;
        this.prix = prixInitial;
        this.tempsDepart = tempsDepart;
        this.duree = duree;
    }

    public Vendeur getVendeur(){
        return this.vendeur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public int getPrix() {
        return prix;
    }
}
