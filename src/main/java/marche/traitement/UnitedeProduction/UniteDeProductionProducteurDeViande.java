package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.ProducteurDeViande;
import marche.traitement.Produit.Viande.Cochon;
import marche.traitement.Produit.Viande.Viande;
import marche.traitement.Produit.Viande.vache;

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



    public Viande produire(int quantite, String type, String peremption)
    {
        if (type.equals("cochon"))
            return new Cochon(quantite, peremption, "Kilogrammes");
        else
            return new vache(quantite, peremption, "Kilogrammes");
    }

}