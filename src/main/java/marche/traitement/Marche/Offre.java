package marche.traitement.Marche;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Offre
{

    private int prix;
    private Produit produit;
    private List<Acteur> acheteurPotentiel = new ArrayList<Acteur>();


    /**
     * Default constructor
     */
    public Offre(int prix, Produit produit)
    {
        this.prix = prix;
        this.produit = produit ;

        /* YAGNI
        this.produit.setQuantite(quantite);
        System.out.println(this.produit.getQuantite()); //TEST
        System.out.println(produit.getQuantite()); //Test

        produit.enleverQuantite(quantite);
        produit.setQuantite(produit.getQuantite()-quantite);
*/


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


    public Produit getProduit() {
        return produit;
    }

    public List<Acteur> getAcheteurPotentiel() {
        return acheteurPotentiel;
    }

    public void addAcheteurPotentiel(Acteur acheteurPotentiel) {
        this.acheteurPotentiel.add(acheteurPotentiel);
    }


}