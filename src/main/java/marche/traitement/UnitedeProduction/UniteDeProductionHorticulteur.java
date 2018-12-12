package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Horticulteur;
import marche.traitement.Produit.Epinards;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class UniteDeProductionHorticulteur extends UniteDeProduction {


    private ArrayList<Horticulteur> producteurs;
    /**
     * Default constructor
     */
    public UniteDeProductionHorticulteur() {
        super();
    }

    /**
     * 
     */




    public Epinards produire(int quantite, String type, String peremption) {
        // TODO implement here
        return new Epinards(quantite,peremption,"Kilogrammes");
    }

}