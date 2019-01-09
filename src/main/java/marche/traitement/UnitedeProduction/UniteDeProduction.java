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

    /**
     * créer une unité de production
     * @param nom correspond au nom de l'UP
     */
    public UniteDeProduction(String nom)
    {
        this.nom = nom;
        Initialisation.listeUniteDeProduction.add(this);
    }

    /**
     * Ajoute un producteur a la liste des producteurs de viandes
     * @param producteur Producteur que l'on ajoute à l'unité de production correspondante de la classe
     */

    public abstract void ajouterMembre(Producteur producteur);

	/**
     * Produit un produit issu de la viande avec la quantite le type la date de peremption et le producteur
     * @param  quantite  correspond à la quantité à produire
     * @param type correspond au type d'aliment à produire
     * @param peremption désine la date de peremption du produit
     * @param producteur est le producteur qui produit à travers l'unité de production
     */
    public abstract void produire(Integer quantite, String type, LocalDate peremption, Producteur producteur);


    public String getNom() {
        return nom;
    }
    public abstract ArrayList<Producteur> getMembre();
}