package marche.traitement.UnitedeProduction;


import marche.traitement.Producteurs.Arboriculteur;

import marche.traitement.Produit.Fruit.Fruit;
import marche.traitement.Produit.Fruit.Pomme;

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



    public Pomme produire(int quantite, String type, String peremption)
    {
        return new Pomme(quantite,peremption,"Kilogrammes");
    }

}