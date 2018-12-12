package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.Produit.ProduitsLaitiers.Fromage;
import marche.traitement.Produit.ProduitsLaitiers.Lait;
import marche.traitement.Produit.ProduitsLaitiers.ProduitsLaitier;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class UniteDeProductionLaitier extends UniteDeProduction
{


    public ArrayList<ProducteurLaitier> producteurs;
    /**
     * Default constructor
     */
    public UniteDeProductionLaitier() {
    }

    /**
     * 
     */



    public ProduitsLaitier produire(int quantite, String type, String peremption)
    {
        if (type.equals("lait"))
            return new Lait(quantite,peremption, "Litres");
        else
            return  new Fromage(quantite, peremption, "Kilogrammes");
    }

}