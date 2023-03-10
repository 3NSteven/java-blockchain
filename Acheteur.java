public class Acheteur {

    private final String id;

    private double fonds;

    private Enchere enchereSuivie;

    public Acheteur(double fonds){
        this.id = Id.createID();
        this.fonds = fonds;
    }

    public String getId() {
        return id;
    }

    public Enchere getEnchereSuivie(){
        return enchereSuivie;
    }

    public double getFonds(){
        return fonds;
    }

    public void connexionEnchere(Enchere enchereASuivre){
        this.enchereSuivie = enchereASuivre;
    }

    public void envoyerOffre(double nouveauPrix){
        if(this.enchereSuivie.getMeilleureOffre() == null){ //si aucune offre n'a encore été proposée
            if(this.enchereSuivie.getPrixInitial() <= nouveauPrix){  //si le prix égal ou au dessus du prix initial
                if(nouveauPrix <= this.fonds){  //si le porte-feuille de l'acheteur contient assez d'argent
                    this.enchereSuivie.setMeilleureOffre(new Offre(this.enchereSuivie, this, nouveauPrix));
                }
                else{   //si le porte-feuille de l'acheteur ne contient pas assez d'argent
                    System.out.println("Votre porte-feuille n'a pas assez de fonds pour payer cette somme.");
                }
            }
            else{   //si le prix n'est pas assez élevé
                System.out.println("Votre proposition est inférieure au prix de départ.");
            }
        }
        else if(this.enchereSuivie.getMeilleureOffre().getPrix() < nouveauPrix){   //si un précédent acheteur a déjà proposé une offre pour l'enchere suivie
            if(nouveauPrix <= this.fonds){  //si le porte-feuille de l'acheteur contient assez d'argent
                this.enchereSuivie.setMeilleureOffre(new Offre(this.enchereSuivie, this, nouveauPrix));
            }
            else{   //si le porte-feuille de l'acheteur ne contient pas assez d'argent
                System.out.println("Votre porte-feuille n'a pas assez de fonds pour payer cette somme.");
            }
        }
        else{   //si le prix n'est pas assez élevé
            System.out.println("Votre proposition est inférieure ou égale à la proposition actuelle.");
        }
    }
}
