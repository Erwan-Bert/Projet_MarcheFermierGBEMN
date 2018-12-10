package marche.traitement.Producteurs;

public class ProducteurBio extends Producteur
{
    //prend un attribut producteur
    private Producteur producteur;

    //constructeur
    public ProducteurBio (Producteur prod)
    {

      this.producteur = prod;

    }


    //méthode spécifique au producteur bio
    public void certifierBio ()
    {
        System.out.println(this.producteur + " est un producteur bio");
    }


}
