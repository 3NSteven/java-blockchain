public class Enchere /*implements Runnable*/ {

    private final String id;
    private final Vendeur vendeur;
    private final String nomProduit;

    private int tempsDepart;
    private int duree;

    private final double prixInitial;

    private Offre meilleureOffre;

    private Bloc dernierBloc;


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
        this.id = Id.createID();
        Market.addEnchere(this.id, this);
    }

    public Vendeur getVendeur(){
        return this.vendeur;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public boolean hasOffre() {
        if(meilleureOffre != null){
            return true;
        }
        return false;
    }

    public Offre getMeilleureOffre() {
        return meilleureOffre;
    }

    public void setMeilleureOffre(Offre meilleureOffre) {
        if(this.meilleureOffre == null){   //s'il s'agit de la première offre effectuée par un acheteur
            this.dernierBloc = new Bloc(meilleureOffre);
        }
        else{
            this.dernierBloc = new Bloc(meilleureOffre, this.dernierBloc);
        }
        this.meilleureOffre = meilleureOffre;
    }

    public double getPrixInitial() {
        return prixInitial;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        if(hasOffre()){ //si au moins une offre a été proposée par un acheteur
            return "Enchère: " + id +
                    "\nVendeur: " + vendeur.getId() +
                    "\nProduit mis en vente: " + nomProduit +
                    "\nTemps de départ de l'enchère: " + tempsDepart + " minutes\n" +
                    "Temps restant: " + duree + " minutes\n" +
                    "Prix de départ: " + prixInitial + " euros\n" +
                "Meilleure offre: " + meilleureOffre.getPrix() + " euros\n" +
                    "Acheteur proposeur de l'offre: " + meilleureOffre.getAcheteur().getId();
        }
        else{   //si aucun acheteur n'a proposé d'offre pour le moment
            return "Enchère: " + id +
                    "\nVendeur: " + vendeur.getId() +
                    "\nProduit mis en vente: " + nomProduit +
                    "\nTemps de départ de l'enchère: " + tempsDepart + " minutes\n" +
                    "Temps restant: " + duree + " minutes\n" +
                    "Prix de départ: " + prixInitial + " euros\n" +
                "Aucune offre proposée pour le moment.";
        }
    }
}
