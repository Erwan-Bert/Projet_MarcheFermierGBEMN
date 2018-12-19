package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Apiculteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Miel;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionApiculteur extends UniteDeProduction {

    private String nom;
    public ArrayList<Apiculteur> producteurs = new ArrayList<>();
    /**
     * Default constructor
     */
    public UniteDeProductionApiculteur(String nom) {

        super(nom);
    }

    @Override
    protected void ajouterMembre(Producteur producteur)throws IllegalStateException {
        try
        {
            producteurs.add((Apiculteur) producteur);
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public Miel produire(int quantite, String type, LocalDate peremption) {
        // TODO implement here
        return new Miel(quantite,peremption,"Kilogrammes");
    }

}