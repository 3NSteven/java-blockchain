public class Bloc {
    private final Offre offre;
    private final int hashPrecedentBloc;
    private final int hashBlocActuel;

    public Bloc(Offre offre){   //pour le premier bloc
        this.offre = offre;
        this.hashPrecedentBloc = 0;
        this.hashBlocActuel = offre.toString().hashCode();
        System.out.println("Bloc: "+offre+"\n"+offre.toString()+"\n"+hashBlocActuel);
    }

    public Bloc(Offre offre, int hashPrecedentBloc){   //pour les blocs suivants
        this.offre = offre;
        this.hashPrecedentBloc = hashPrecedentBloc;
        this.hashBlocActuel = (offre.toString() + hashPrecedentBloc).hashCode();
        System.out.println("Bloc: "+offre+"\n"+offre.toString()+"\n"+hashPrecedentBloc+"\n"+(offre.toString()+hashPrecedentBloc)+"\n"+hashBlocActuel);
    }

    public int getHash(){
        return hashBlocActuel;
    }

}
