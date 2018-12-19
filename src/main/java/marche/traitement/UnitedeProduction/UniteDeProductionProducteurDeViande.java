package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurDeViande;
import marche.traitement.Produit.Viande.Cochon;
import marche.traitement.Produit.Viande.Viande;
import marche.traitement.Produit.Viande.vache;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionProducteurDeViande extends UniteDeProduction {


    public ArrayList<ProducteurDeViande> producteurs = new ArrayList<>();
    private String nom;
    /**
     * Default constructor
     */
    public UniteDeProductionProducteurDeViande(String nom) {

        super(nom);
    }

    @Override
    protected void ajouterMembre(Producteur producteur)throws ClassCastException {
        try
        {
            producteurs.add((ProducteurDeViande) producteur);
        }
        catch (ClassCastException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Viande produire(int quantite, String type, LocalDate peremption)
    {
        if (type.equals("cochon"))
            return new Cochon(quantite, peremption, "Kilogrammes");
        else
            return new vache(quantite, peremption, "Kilogrammes");
    }

}