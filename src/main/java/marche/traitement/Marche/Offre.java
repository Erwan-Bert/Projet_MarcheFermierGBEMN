package marche.traitement.Marche;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Produit.Produit;

import java.util.*;

/**
 * 
 */
public class Offre
{

    private int prix;
    private int quantite;
    private Produit produit;
    private ArrayList<Acteur> acheteurPotentiel = new ArrayList<Acteur>();


    /**
     * Default constructor
     */
    public Offre(int prix, int quantite, Produit produit)
    {
        this.prix = prix;
        this.quantite = quantite;
        this.produit = produit;
    }

    /**
     * Function archiver
     */
    public void archiver() {
        // TODO implement here
    }

    public int getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public ArrayList<Acteur> getAcheteurPotentiel() {
        return acheteurPotentiel;
    }

    public void addAcheteurPotentiel(Acteur acheteurPotentiel) {
        this.acheteurPotentiel.add(acheteurPotentiel);
    }


}