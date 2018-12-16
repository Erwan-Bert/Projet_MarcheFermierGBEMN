package marche.traitement.UnitedeProduction;


import marche.traitement.Producteurs.Arboriculteur;

import marche.traitement.Produit.Fruit.Fruit;
import marche.traitement.Produit.Fruit.Pomme;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class UniteDeProductionArboriculteur extends UniteDeProduction {


    /**
     * Default constructor
     */
    public UniteDeProductionArboriculteur() {
        super();
    }

    /**
     * 
     */



    public Pomme produire(int quantite, String type, LocalDate peremption)
    {
        return new Pomme(quantite,peremption,"Kilogrammes");
    }

}