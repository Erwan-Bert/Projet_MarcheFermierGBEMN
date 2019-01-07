package marche.traitement.Producteurs.DecorateurProducteur;

import marche.traitement.Producteurs.Producteur;

public class ProducteurBio extends DecorateurProducteur
{
    private Producteur producteur;

    /**
     * Constructeur
     */
    public ProducteurBio (Producteur prod)
    {
        super(prod);

    }

	
	/**
     * méthode spécifique au producteur bio qui permet de certifier un producteur Bio
     */
    public void certifierBio ()
    {
        System.out.println(this.producteur + " est un producteur bio");
    }


}
