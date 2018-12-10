package marche.traitement.Produit;

import marche.traitement.Produit.ProduitsLaitiers.ProduitsLaitier;

import java.util.Date;

/**
 * 
 */
public class Epinards extends Produit {

    public String Unite;

    public Epinards(int quantite, Date dateDePeremption, String unite) {
        super(quantite, dateDePeremption);
        Unite = unite;
    }

    public String getUnite() {
        return Unite;
    }
}