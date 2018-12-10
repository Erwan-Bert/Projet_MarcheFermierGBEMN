package marche.traitement.UnitedeProduction;


import marche.traitement.Producteurs.Arboriculteur;

import marche.traitement.Produit.Fruit.Fruit;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class UniteDeProductionArboriculteur extends UniteDeProduction {

    public ArrayList<Arboriculteur> producteurs;

    /**
     * Default constructor
     */
    public UniteDeProductionArboriculteur() {
        super();
    }

    /**
     * 
     */



    public Fruit produire(int quantite) {
        // TODO implement here
        return new Fruit(quantite,new Date(System.currentTimeMillis()));
    }

}