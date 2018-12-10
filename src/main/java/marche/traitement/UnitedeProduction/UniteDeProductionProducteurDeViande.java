package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.ProducteurDeViande;
import marche.traitement.Produit.Viande.Viande;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class UniteDeProductionProducteurDeViande extends UniteDeProduction {


    public ArrayList<ProducteurDeViande> producteurs;
    /**
     * Default constructor
     */
    public UniteDeProductionProducteurDeViande() {

        super();
    }

    /**
     * 
     */



    public Viande produire(int quantite) {
        // TODO implement here
        return new Viande(quantite, new Date(System.currentTimeMillis()));
    }

}