package marche.traitement.Produit.ProduitsLaitiers;

import marche.traitement.Produit.Produit;

import java.util.Date;

/**
 * 
 */
public class Lait extends ProduitsLaitier {

    public String unite;

    public Lait(int quantite, String dateDePeremption, String unite) {
        super(quantite, dateDePeremption);
        this.unite = unite;
    }

    public String getUnite() {
        return unite;
    }
}