package marche.traitement.Acteurs;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;

/**
 * 
 */
public class VendeurAcheteur extends Acteur {

    /**
     * Default constructor
     */
    public VendeurAcheteur(double solde) {
        super(solde);
    }
    public VendeurAcheteur() {
    }
    /**
     * 
     */
    public ArrayList<Produit> stocks = new ArrayList<Produit>();



    /**
     * @param //int quantite
     * @param //int prix
     * @param //Produit produit
     * @return
     */
    public Offre creeUneOffre(int quantite,int prix, Produit produit) {
        // TODO implement here
        return null;
    }

    public void addToStock(Produit produit){//
    }

}