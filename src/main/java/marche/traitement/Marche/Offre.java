package marche.traitement.Marche;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Offre
{

    private boolean valider = false;
    private int prix;
    private Produit produit;
    private List<Acteur> acheteurPotentiel = new ArrayList<Acteur>();
    private VendeurAcheteur vendeur;

    public VendeurAcheteur getVendeur() {
        return vendeur;
    }




    /**
     * Default constructor
     */
    public Offre(int prix, Produit produit, VendeurAcheteur vendeurAcheteur)
    {
        this.prix = prix;
        this.produit = produit;
        this.vendeur = vendeurAcheteur;

        /* YAGNI
        this.produit = produit
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

    public boolean isValider() {
        return valider;
    }

    public void validerOffre()
    {
        this.valider = true;
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