package marche.traitement.Produit.ProduitsLaitiers;

import java.time.LocalDate;

/**
 * 
 */
public class Lait extends ProduitsLaitier {
    @Override
    public String getNom() {
        return "lait";
    }

    public Lait(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }
}