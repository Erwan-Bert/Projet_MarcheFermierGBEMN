package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Produit;

import java.time.LocalDate;

/**
 * 
 */
public abstract class UniteDeProduction {

    private String nom;

    public UniteDeProduction(String nom)
    {
        this.nom = nom;
    }


    public void ajouterProducteur(Producteur producteur)
    {
        ajouterMembre(producteur);
    }

    protected abstract void ajouterMembre(Producteur producteur);

    public Produit getProduit(int quantite, String type, LocalDate peremption)
    {
        return produire(quantite, type, peremption);
    }

    protected abstract Produit produire(int quantite, String type, LocalDate peremption);



}