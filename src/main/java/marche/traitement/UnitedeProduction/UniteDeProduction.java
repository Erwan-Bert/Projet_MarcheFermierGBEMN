package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;

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

    /*public Produit getProduit(int quantite, String type, LocalDate peremption)
    {
        return produire(quantite, type, peremption);
    }*/

    
    public abstract void produire(int quantite, String type, LocalDate peremption, Producteur producteur);
}