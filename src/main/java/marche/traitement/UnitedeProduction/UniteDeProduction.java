package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;

/**
 * 
 */
public abstract class UniteDeProduction {


    private ArrayList<Producteur> groupeDeProd;
    /**
     * Default constructor
     */
    public UniteDeProduction()
    {

    }

    public abstract Produit produire(int quantite);



}