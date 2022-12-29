public class Acheteur {

    private Enchere enchereSuivie;

    public Acheteur(){}

    public void connexionEnchere(Enchere enchereASuivre){
        this.enchereSuivie = enchereASuivre;
    }

    public void envoyerOffre(double nouveauPrix){
        if(this.enchereSuivie.getMeilleureOffre() == null){ //si aucune offre n'a encore été proposée
            if(this.enchereSuivie.getPrixInitial() > nouveauPrix){  //si le prix égal ou au dessus du prix initial
                this.enchereSuivie.setMeilleureOffre(new Offre(this.enchereSuivie, this, nouveauPrix));
            }
            else{   //si le prix n'est pas assez élevé
                System.out.println("Votre proposition est inférieure à la proposition actuelle.");
            }
        }
        else if(this.enchereSuivie.getMeilleureOffre().getPrix() >= nouveauPrix){   //si un précédent acheteur a déjà proposé une offre pour l'enchere suivie
            this.enchereSuivie.setMeilleureOffre(new Offre(this.enchereSuivie, this, nouveauPrix));
        }
        else{   //si le prix n'est pas assez élevé
            System.out.println("Votre proposition est inférieure à la proposition actuelle.");
        }
    }
}
