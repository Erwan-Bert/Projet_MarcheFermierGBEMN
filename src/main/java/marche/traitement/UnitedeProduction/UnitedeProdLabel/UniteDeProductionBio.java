package marche.traitement.UnitedeProduction.UnitedeProdLabel;


import marche.traitement.Producteurs.DecorateurProducteur.ProducteurBio;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Produit;
import marche.traitement.Produit.ProduitBio;
import marche.traitement.UnitedeProduction.UniteDeProduction;

import java.time.LocalDate;
import java.util.ArrayList;

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
            up.ajouterMembre(((ProducteurBio) producteur).getProducteur());
        }
        catch (ClassCastException e)
        {
            System.out.println("Le producteur que vous tentez d'ajouter n'a pas la certification Bio");
        }

    }


    @Override
    public void produire(Integer quantite, String type, LocalDate peremption, Producteur producteur) throws ClassCastException
    {   try{
        if (this.porducteursLabelises.contains(producteur))
        {
            ProducteurBio producteurBio = (ProducteurBio) producteur;
            up.produire(quantite,type,peremption, producteurBio.getProducteur());
            Produit produit = producteurBio.getProducteur().getProduitDansStock(quantite,type,peremption);
            if(produit != null){
                ProduitBio produitBio = new ProduitBio(produit);
                producteur.ajouterAuStock(produitBio);
            }else
            System.out.println("La production a échoué");


        }else{
            System.out.println("le producteur n'appartient pas à l'unité");
        }
    }catch (ClassCastException e){
        System.out.println("Le producteur ne convient pas à l'unité de production");
    }

    }
    @Override
    public ArrayList<Producteur> getMembre()
    {
        return new ArrayList<>(up.getMembre());
    }

}

