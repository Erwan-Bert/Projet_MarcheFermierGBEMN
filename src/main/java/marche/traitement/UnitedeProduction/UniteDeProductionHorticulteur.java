package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Horticulteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Epinards;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionHorticulteur extends UniteDeProduction {

    private String nom;
    public ArrayList<Horticulteur> producteurs = new ArrayList<>();
    /**
     * Default constructor
     */
    public UniteDeProductionHorticulteur(String nom) {
        super(nom);
    }

    @Override
    protected void ajouterMembre(Producteur producteur)throws IllegalStateException {
        try
        {
            producteurs.add((Horticulteur) producteur);
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Epinards produire(int quantite, String type, LocalDate peremption) {
        // TODO implement here
        return new Epinards(quantite,peremption,"Kilogrammes");
    }

}