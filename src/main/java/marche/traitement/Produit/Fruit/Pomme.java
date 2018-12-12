package marche.traitement.Produit.Fruit;

import java.util.Date;

/**
 * 
 */
public class Pomme extends Fruit {

    private String Unite;

    public Pomme(int quantite, String dateDePeremption, String unite) {
        super(quantite, dateDePeremption);
        Unite = unite;
    }

    public String getUnite() {
        return Unite;
    }
}