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

    public List<Produit> getStocks() {
        return stocks;
    }

    /**
     * 
     */
    private List<Produit> stocks = new ArrayList<Produit>();



    /**
     * @param //int quantite
     * @param //int prix
     * @param //Produit produit
     * @return
     */
    public Offre creerUneOffre(int quantite,int prix, Produit produit)throws ArithmeticException,IllegalArgumentException {

        if(prix<0)
            throw new ArithmeticException("prix négatif");
        if(quantite< 0 )
            throw new ArithmeticException("quantite négative");
        if(produit == null)
            throw new IllegalArgumentException("rentrez un produit valide");

        return new Offre(prix,quantite,produit);

    }

    /**
     * si le produit est du même type, date de péremption et unité qu'un produit dans le stock
     * on combine les produits, sinon on ajoute le produit au stock dans une autre case
     * @param produit
     */
    public void ajouterAuStock(Produit produit){
        boolean dejaDansLeStock = false;
        for (Produit stock: stocks ) {
            if(stock.getClass().equals( produit.getClass()) &&
                    stock.getDateDePeremption() == produit.getDateDePeremption()&&
                    stock.getUnite().equals(produit.getUnite())){

                    stock.ajouterQuantite(produit.getQuantite());
                    dejaDansLeStock = true;
                }


        }
        if(!dejaDansLeStock ){
            stocks.add(produit);
        }
    }

}