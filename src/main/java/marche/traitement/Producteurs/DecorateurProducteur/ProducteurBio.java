package marche.traitement.Producteurs.DecorateurProducteur;

import marche.traitement.Producteurs.Producteur;

public class ProducteurBio extends DecorateurProducteur
{


    /**
     * Permet d'instancier un producteur bio à partir d'un producteur basique
     * @param producteur Producteur de base
     */
    public ProducteurBio (Producteur producteur)
    {
        super(producteur);
    }

    /**
     * retourne le producteur de base encapsulé dans le producteurbio
     * @return le producteur contenu dans le producteur bio
     */
    public Producteur getProducteur()
    {
        return prod;
    }



}
