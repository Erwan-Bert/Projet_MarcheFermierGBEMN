package marche.traitement.Produit.ProduitsLaitiers;

import marche.traitement.Produit.Produit;

import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
public abstract class ProduitsLaitier extends Produit {


    public ProduitsLaitier() {
    }

    public ProduitsLaitier(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }
}