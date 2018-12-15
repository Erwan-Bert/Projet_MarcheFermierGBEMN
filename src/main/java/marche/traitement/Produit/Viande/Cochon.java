package marche.traitement.Produit.Viande;


import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
public class Cochon extends Viande {



    public Cochon(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

    public String getUnite() {
        return unite;
    }
}