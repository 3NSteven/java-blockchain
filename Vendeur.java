public class Vendeur {

    public Vendeur(){}

    public Enchere creerEnchere(String nomProduit, int prixInitial, int tempsDepart, int duree){
        return new Enchere(this, nomProduit, prixInitial, tempsDepart, duree);
    }
}
