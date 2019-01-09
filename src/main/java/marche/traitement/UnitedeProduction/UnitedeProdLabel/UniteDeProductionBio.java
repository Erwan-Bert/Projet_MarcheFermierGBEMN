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


    /**
     * créer une unité de production bio
     * @param up correspond à une unité de production basique(utilise le constructeur de UniteProductionLabelise)
     */
    public UniteDeProductionBio(UniteDeProduction up)
    {
        super(up);
    }

    /**
     * Ajoute un producteur a la liste des producteurs de viandes
     * @param producteur Producteur que l'on ajoute à l'unité de production correspondante de la classe
     */
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

    /**
     * Produit un produit issu de la viande avec la quantite le type la date de peremption et le producteur
     * @param  quantite  correspond à la quantité à produire
     * @param type correspond au type d'aliment à produire
     * @param peremption désine la date de peremption du produit
     * @param producteur est le producteur qui produit à travers l'unité de production
     */
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

    /**
     *
     * @return les membres appartenant à l'unité de production
     */
    @Override
    public ArrayList<Producteur> getMembre()
    {
        return new ArrayList<>(up.getMembre());
    }

    @Override
    public String toString() {
        return "nom= " + getNom() +
                ", producteurs=" + getMembre() +
                '}';
    }

}

