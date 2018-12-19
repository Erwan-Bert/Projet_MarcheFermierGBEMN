package marche.traitement.UnitedeProduction;


import marche.traitement.Producteurs.Arboriculteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Fruit.Pomme;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionArboriculteur extends UniteDeProduction {

    private String nom;
    public ArrayList<Arboriculteur> producteurs = new ArrayList<>();
    /**
     * Default constructor
     */
    public UniteDeProductionArboriculteur(String nom) {
        super(nom);
    }

    @Override
    protected void ajouterMembre(Producteur producteur)throws IllegalStateException {
        try
        {
            producteurs.add((Arboriculteur) producteur);
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
    }

    public Pomme produire(int quantite, String type, LocalDate peremption)
    {
        return new Pomme(quantite,peremption,"Kilogrammes");
    }

}