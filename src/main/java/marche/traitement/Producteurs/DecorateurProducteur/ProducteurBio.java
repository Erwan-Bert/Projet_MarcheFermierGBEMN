package marche.traitement.Producteurs.DecorateurProducteur;

import marche.traitement.Producteurs.Producteur;

public class ProducteurBio extends DecorateurProducteur
{
    //prend un attribut producteur
    private Producteur producteur;

    //constructeur
    public ProducteurBio (Producteur prod)
    {
        super(prod);

    }


    //méthode spécifique au producteur bio
    public void certifierBio ()
    {
        System.out.println(this.producteur + " est un producteur bio");
    }


}
