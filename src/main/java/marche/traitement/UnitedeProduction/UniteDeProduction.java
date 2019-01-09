package marche.traitement.UnitedeProduction;

import marche.traitement.Initialisation.Initialisation;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Produit;

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

    /**
     * sépare un produit en deux produit
     * @param quantiteAEnlever
     * @return
     */
    public static Produit scinderProduit(Produit produit, double quantiteAEnlever){
        Produit nouveauProduit = produit;

        nouveauProduit.setQuantite(0);
        System.out.println(produit.getQuantite());
        System.out.println(nouveauProduit.getQuantite());

        return nouveauProduit;
    }

    public String getNom() {
        return nom;
    }
    public abstract ArrayList<Producteur> getMembre();
}