package marche.traitement.Producteurs.DecorateurProducteur;

import marche.traitement.Producteurs.Producteur;

public abstract class DecorateurProducteur extends Producteur {

    protected Producteur prod;

    /**
     * Permet de decorer un producteur
     * @param producteur Producteur à décorer
     */
    public DecorateurProducteur (Producteur producteur)
    {
        super();
        prod = producteur;
    }
}
