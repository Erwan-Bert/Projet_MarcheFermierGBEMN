package marche.traitement.Producteurs;

public class ProducteurBio extends Producteur
{
    //prend un attribut producteur
    private Producteur producteur;

    //constructeur
    public ProducteurBio (double solde,int limite,Producteur prod)
    {
        super(solde,limite);
      this.producteur = prod;

    }


    //méthode spécifique au producteur bio
    public void certifierBio ()
    {
        System.out.println(this.producteur + " est un producteur bio");
    }


}
