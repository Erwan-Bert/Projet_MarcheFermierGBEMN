package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.ProducteurLaitier;
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



    public ProduitsLaitier produire(int quantite) {
        // TODO implement here
        return new ProduitsLaitier(quantite,new Date(System.currentTimeMillis()));
    }

}