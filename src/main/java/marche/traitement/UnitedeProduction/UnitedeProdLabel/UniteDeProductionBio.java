package marche.traitement.UnitedeProduction.UnitedeProdLabel;

/*
public class UniteDeProductionBio extends UniteDeProductionLabelise
{



    public UniteDeProductionBio(UniteDeProduction up)
    {
        super(up);
    }

    @Override
    public void ajouterMembre(Producteur producteur) throws ClassCastException
    {
        try
        {
            this.porducteursLabelises.add((ProducteurBio)producteur);
            up.ajouterMembre(producteur);
        }
        catch (ClassCastException e)
        {
            System.out.println("Le producteur que vous tentez d'ajouter n'a pas la certification Bio");
        }

    }
/*
    @Override
    public void produire(int quantite, String type, LocalDate peremption, Producteur producteur)
    {
        if (this.porducteursLabelises.contains(producteur))
        {
            up.produire(quantite,type,peremption,producteur.get);
            producteur.ajouterAuStock(new ProduitBio());
        }
    }
    */
