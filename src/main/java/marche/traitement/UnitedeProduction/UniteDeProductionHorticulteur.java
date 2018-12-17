package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Horticulteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Epinards;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 */
public class UniteDeProductionHorticulteur extends UniteDeProduction {


    /**
     * Default constructor
     */
    public UniteDeProductionHorticulteur() {
        super();
        this.groupeDeProd =  new ArrayList<Producteur>();

    }

    /**
     * 
     */


    public void AddMembre(Horticulteur H)
    {
        if (H instanceof Horticulteur)
        {
            this.groupeDeProd.add(H);
        }

    }

    public Epinards produire(int quantite, String type, LocalDate peremption) {
        // TODO implement here
        return new Epinards(quantite,peremption,"Kilogrammes");
    }

}