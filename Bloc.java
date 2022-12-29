public class Bloc {
    private final Offre offre;
    private final String hashPrecedentBloc;
    private final String hashBlocActuel;

    public Bloc(Offre offre){   //pour le premier bloc
        this.offre = offre;
        this.hashPrecedentBloc = null;
        this.hashBlocActuel = "" + offre;
    }

    public Bloc(Offre offre, Bloc precedentBloc){   //pour les blocs suivants
        this.offre = offre;
        this.hashPrecedentBloc = precedentBloc.getHash();
        this.hashBlocActuel = offre + precedentBloc.getHash();
    }

    public String getHash(){
        return hashBlocActuel;
    }

}
