public class Vendeur {

    public Vendeur(){}

    public Enchere creerEnchere(String nomProduit, double prixInitial, int tempsDepart, int duree){
        return new Enchere(this, nomProduit, prixInitial, tempsDepart, duree);
    }
}
