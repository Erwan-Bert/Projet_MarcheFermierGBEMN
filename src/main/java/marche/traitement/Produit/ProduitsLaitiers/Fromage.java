package marche.traitement.Produit.ProduitsLaitiers;


import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
public class Fromage extends ProduitsLaitier {


    public Fromage(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

    public String getUnite() {
        return unite;
    }
}