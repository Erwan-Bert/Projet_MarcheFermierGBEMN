package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Apiculteur;
import marche.traitement.Produit.Miel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class UniteDeProductionApiculteur extends UniteDeProduction {


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
    public Miel produire(int quantite, String type, LocalDate peremption) {
        // TODO implement here
        return new Miel(quantite,peremption,"Kilogrammes");
    }

}