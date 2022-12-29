import java.io.IOException;
import java.net.*;

public class Enchere /*implements Runnable*/ {

    private final Vendeur vendeur;
    private final String nomProduit;

    private int tempsDepart;
    private int duree;

    private double prixInitial;

    private Offre meilleureOffre;


    /*
    public void run(){
        ServerSocket server = null;
        Socket sock = null;
        try {
            server = new ServerSocket(7770);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    */

    public Enchere(Vendeur vendeur, String nomProduit, double prixInitial, int tempsDepart, int duree) {
        this.vendeur = vendeur;
        this.nomProduit = nomProduit;
        this.prixInitial = prixInitial;
        this.tempsDepart = tempsDepart;
        this.duree = duree;
    }

    public Vendeur getVendeur(){
        return this.vendeur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public Offre getMeilleureOffre() {
        return meilleureOffre;
    }

    public void setMeilleureOffre(Offre meilleureOffre) {
        this.meilleureOffre = meilleureOffre;
    }

    public double getPrixInitial() {
        return prixInitial;
    }

    @Override
    public String toString() {
        if(meilleureOffre != null){ //si au moins une offre a été proposée par un acheteur
            return "Enchere:\n" +
                    "Produit mis en vente: " + nomProduit +
                    "\nTemps de départ de l'enchère: " + tempsDepart + " minutes\n" +
                    "Temps restant: " + duree + " minutes\n" +
                    "Prix de départ: " + prixInitial + " euros\n" +
                "Meilleure offre: " + meilleureOffre.getPrix() + " euros";
        }
        else{   //si aucun acheteur n'a proposé d'offre pour le moment
            return "Enchere:\n" +
                    "Produit mis en vente: " + nomProduit +
                    "\nTemps de départ de l'enchère: " + tempsDepart + " minutes\n" +
                    "Temps restant: " + duree + " minutes\n" +
                    "Prix de départ: " + prixInitial + " euros\n" +
                "Aucune offre proposée pour le moment.";
        }
    }
}
