package marche.traitement.Acteurs;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class VendeurAcheteur extends Acteur {

    /**
     * Default constructor
     */
    public VendeurAcheteur(double solde, String nom) {
        super(solde, nom);
    }
    public VendeurAcheteur() {
    }
    /**
     * 
     */
    public List<Produit> stocks = new ArrayList<Produit>();



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

    public void addToStock(Produit produit){
        for (Produit stock: stocks ) {
            //if(stock instanceof )
        }
        stocks.add(produit);
    }

}