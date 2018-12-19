package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.Produit.ProduitsLaitiers.Fromage;
import marche.traitement.Produit.ProduitsLaitiers.Lait;
import marche.traitement.Produit.ProduitsLaitiers.ProduitsLaitier;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionLaitier extends UniteDeProduction
{


    public ArrayList<ProducteurLaitier> producteurs = new ArrayList<>();
    private String nom;

    public UniteDeProductionLaitier(String nom)
    {
        super(nom);
    }

    @Override
    protected void ajouterMembre(Producteur producteur)throws ClassCastException {
            producteurs.add((ProducteurLaitier) producteur);
    }


    public ProduitsLaitier produire(int quantite, String type, LocalDate peremption)
    {
        if (type.equals("lait"))
            return new Lait(quantite,peremption, "Litres");
        else
            return  new Fromage(quantite, peremption, "Kilogrammes");
    }

}