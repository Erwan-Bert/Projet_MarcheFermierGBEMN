package marche.traitement.Produit;

import java.util.Date;

/**
 * 
 */
public class Miel extends Produit {

    public String Unite;

    public Miel(int quantite, String dateDePeremption, String unite) {
        super(quantite, dateDePeremption);
        Unite = unite;
    }

    public String getUnite() {
        return Unite;
    }
}