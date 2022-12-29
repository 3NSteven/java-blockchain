import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class Market {
    private static HashMap<String, Enchere> market = new HashMap<>();

    public static void addEnchere(String id, Enchere enchere){
        market.put(id, enchere);
    }

    public static Enchere getEnchereById(String id){
        return market.get(id);
    }

    public static String listerEncheres(){
        /*
        final String[] output = {"Liste des enchères: \n"};
        market.forEach((k,v) -> output[0] = output[0] + k + ") " + v.getNomProduit() + "\n");
        return output[0];
         */

        AtomicReference<String> output = new AtomicReference<>("Liste des enchères: \n");
        market.forEach((k,v) -> output.set(output + k + ") " + v.getNomProduit() + "\n"));
        return output.get();
    }
}
