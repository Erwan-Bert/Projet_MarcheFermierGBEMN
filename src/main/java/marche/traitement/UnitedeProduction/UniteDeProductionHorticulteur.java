package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Horticulteur;
import marche.traitement.Produit.Epinards;

import java.time.LocalDate;
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
        this.producteurs = new ArrayList<Horticulteur>();

    }

    /**
     * 
     */


    public void AddMembre(Horticulteur H)
    {
        if (H instanceof Horticulteur)
        {
            this.producteurs.add(H);
        }

    }

    public Epinards produire(int quantite, String type, LocalDate peremption) {
        // TODO implement here
        return new Epinards(quantite,peremption,"Kilogrammes");
    }

}