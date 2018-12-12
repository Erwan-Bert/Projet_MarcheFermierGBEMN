package marche.traitement.Produit.Viande;

import marche.traitement.Produit.Produit;

import java.util.Date;

/**
 * 
 */
public class vache extends Viande {

    public String Unite;

    public vache(int quantite, String dateDePeremption, String unite) {
        super(quantite, dateDePeremption);
        Unite = unite;
    }

    public String getUnite() {
        return Unite;
    }
}