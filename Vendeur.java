public class Vendeur {

    private final String id;
    public Vendeur(){
        this.id = Id.createID();
    }

    public String getId() {
        return id;
    }

    public Enchere creerEnchere(String nomProduit, double prixInitial, int tempsDepart, int duree){
        return new Enchere(this, nomProduit, prixInitial, tempsDepart, duree);
    }
}
