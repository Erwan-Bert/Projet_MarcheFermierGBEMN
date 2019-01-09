package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.Produit.ProduitsLaitiers.Fromage;
import marche.traitement.Produit.ProduitsLaitiers.Lait;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionLaitier extends UniteDeProduction
{


    public ArrayList<ProducteurLaitier> producteurs = new ArrayList<>();


    public UniteDeProductionLaitier(String nom)
    {
        super(nom);
    }

    /**
     * Ajoute un producteur a la liste des producteurs de viandes
     * @param producteur Producteur que l'on ajoute à l'unité de production correspondante de la classe
     */
    @Override
    public void ajouterMembre(Producteur producteur)throws ClassCastException {
        try
        {
            producteurs.add((ProducteurLaitier) producteur);

        }

        catch (ClassCastException e)

        {
            System.out.println("Le producteur que vous tentez d'ajouter n'est pas du bon type");

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
    public void produire(Integer quantite, String type, LocalDate peremption,Producteur producteur)
    {
        if (producteurs.contains((producteur)))
        {
            if (producteur.getQuantiteStock() + quantite <= producteur.getLimite())
            {
                if (type.equals("lait"))
                producteur.ajouterAuStock(new Lait(quantite,peremption,"Litres"));
                else
                producteur.ajouterAuStock(new Fromage(quantite,peremption,"Kilogrammes"));

            }
            else
            {
                System.out.println("tu peux pas produire autant ta limite de stock est "+ producteur.getLimite());
            }

        }
        else
        {
            System.out.println("Vous n'appartenez pas à une unité de production");
        }

    }

    /**
     *
     * @return les membres appartenant à l'unité de production
     */
    @Override
    public ArrayList<Producteur> getMembre()
    {
        return new ArrayList<>(producteurs);
    }
}