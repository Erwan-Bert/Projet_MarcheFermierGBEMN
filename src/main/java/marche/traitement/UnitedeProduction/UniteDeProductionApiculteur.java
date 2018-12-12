package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Apiculteur;
import marche.traitement.Produit.Miel;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class UniteDeProductionApiculteur extends UniteDeProduction {


    public ArrayList<Apiculteur> producteurs;

    /**
     * Default constructor
     */
    public UniteDeProductionApiculteur() {

        super();
    }

    /**
     * 
     */

    @Override
    public Miel produire(int quantite, String type, String peremption) {
        // TODO implement here
        return new Miel(quantite,peremption,"Kilogrammes");
    }

}