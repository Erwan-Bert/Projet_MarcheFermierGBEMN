package marche.traitement.Acteurs;

import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class VendeurAcheteur extends Acteur {


    protected List<Produit> stocks = new ArrayList<Produit>();
    public List<Produit> getStocks() {
        return stocks;
    }

    /**
     * Default constructor
     */
    public VendeurAcheteur(double solde, String nom) {
        super(solde, nom);
    }
    public VendeurAcheteur() {
    }


    /**
     * @param //int quantite
     * @param //int prix
     * @param //Produit produit
     * @return
     */
    public void creerUneOffre(int prix, Produit produit)throws ArithmeticException,IllegalArgumentException {

        if(prix<0)
            throw new ArithmeticException("prix négatif");
        if(produit == null)
            throw new IllegalArgumentException("rentrez un produit valide");
        if(stocks.contains(produit)){
            Offre offre = new Offre(prix,produit,this);
            if(Controleur.validerOffre(offre)){
                stocks.remove(produit);
                LivreDuMarche.ajouterOffre(offre);
            }else{
                throw new IllegalArgumentException("votre offre a été rejeté par l'amf");
            }
        }
        else {
            throw new IllegalArgumentException("rentrez un produit valide");
        }
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

    //cette méthode permet de connaitre la quantité de tous les éléments du stock combinés
    public double getQuantiteStock()
    {
        double quantiteTotale = 0;
        for (Produit produit:stocks)
        {
            quantiteTotale += produit.getQuantite();
        }
        return quantiteTotale;
    }

    //cette méthode permet d'afficher de manière détailler le stock d'un acheteur vendeur
    public void afficherStock()
    {
        int compteur = 1;
        for (Produit produit :stocks)
        {
            System.out.println(compteur+") "+produit.getQuantite()+" kilo de "+produit.getNom()+" / périme le : "+produit.getDateDePeremption());
            compteur++;
        }
    }


    //cette méthode permet de retourner le produit qui se situe au ième rang du stock
    public Produit getElementStock(int i)
    {
        return stocks.get(i-1);
    }

}