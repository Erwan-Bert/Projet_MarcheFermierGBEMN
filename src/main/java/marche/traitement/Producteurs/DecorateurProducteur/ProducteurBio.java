package marche.traitement.Producteurs.DecorateurProducteur;

import marche.traitement.Producteurs.Producteur;

public class ProducteurBio extends DecorateurProducteur
{



    /**
     * Constructeur
     */
    public ProducteurBio (Producteur producteur)
    {
        super(producteur);
    }

    public Producteur getProducteur()
    {
        return prod;
    }



}
