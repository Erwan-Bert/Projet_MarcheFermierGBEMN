package marche.traitement.Producteurs.DecorateurProducteur;

import marche.traitement.Producteurs.Producteur;

public abstract class DecorateurProducteur extends Producteur {

    protected Producteur prod;

    public DecorateurProducteur (Producteur prod)
    {
        this.prod = prod;
    }
}
