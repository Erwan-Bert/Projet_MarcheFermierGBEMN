package marche.traitement.UnitedeProduction;

import marche.traitement.Initialisation.Initialisation;
import marche.traitement.Producteurs.Producteur;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public abstract class UniteDeProduction {

    private String nom;

    protected UniteDeProduction(){}

    public UniteDeProduction(String nom)
    {
        this.nom = nom;
        Initialisation.listeUniteDeProduction.add(this);
    }

	/**
     * Ajoute un producteur a l'unite de production
     * @param producteur
     */
    /*public void ajouterProducteur(Producteur producteur)
    {
        ajouterMembre(producteur);
    }*/

    public abstract void ajouterMembre(Producteur producteur);

    /*public Produit getProduit(int quantite, String type, LocalDate peremption)
    {
        return produire(quantite, type, peremption);
    }*/

	/**
     * Produit un protuit ,avec sa quantite son type sa date et le producteur qui l'a réalisé
     * @param quantite type peremption producteur
     */
    public abstract void produire(Integer quantite, String type, LocalDate peremption, Producteur producteur);


    public String getNom() {
        return nom;
    }
    public abstract ArrayList<Producteur> getMembre();
}