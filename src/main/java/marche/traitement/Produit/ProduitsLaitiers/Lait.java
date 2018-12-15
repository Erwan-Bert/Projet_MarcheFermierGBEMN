package marche.traitement.Produit.ProduitsLaitiers;

import marche.traitement.Produit.Produit;

import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
public class Lait extends ProduitsLaitier {


    public Lait(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }
}