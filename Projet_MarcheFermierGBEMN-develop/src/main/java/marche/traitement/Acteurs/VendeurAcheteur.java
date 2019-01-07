package marche.traitement.Acteurs;

import marche.traitement.Acteurs.ChoixAcheteur.StrategyChoixAcheteur;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public abstract class VendeurAcheteur extends Acteur {


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
	 * Creer une offre selon la quantité le prix et le Produit
     * @param //int quantite
     * @param //int prix
     * @param //Produit produit
     * @return
     */
    public void creerUneOffre(int prix, Produit produit, StrategyChoixAcheteur strategyChoixAcheteur, LivreDuMarche marche)throws ArithmeticException,IllegalArgumentException {

        if(prix<0)
            throw new ArithmeticException("prix négatif");
        if(produit == null)
            throw new IllegalArgumentException("rentrez un produit valide");
        if(stocks.contains(produit)){
            Offre offre = new Offre(prix,produit,this,strategyChoixAcheteur, marche);
            if(marche.getControleur().validerOffre(offre)){
                stocks.remove(produit);
                marche.ajouterOffre(offre);
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
     * @param Produit produit
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

    /**
     * Retourne la quantitée totale des produits
     * @param Produit produit
	 * @return quantiteTotale
     */
    public double getQuantiteStock()
    {
        double quantiteTotale = 0;
        for (Produit produit:stocks)
        {
            quantiteTotale += produit.getQuantite();
        }
        return quantiteTotale;
    }
	
	/**
     * Affiche de manière détailler le stock d'un acheteur vendeur
     */
    public void afficherStock()
    {
        int compteur = 1;
        for (Produit produit :stocks)
        {
            System.out.println(compteur+") "+produit.getQuantite()+" kilo de "+produit.getNom()+" / périme le : "+produit.getDateDePeremption());
            compteur++;
        }
    }


	/**
     * Retourne le produit qui se situe au ième rang du stock
     */
    public Produit getElementStock(int i)
    {
        return stocks.get(i-1);
    }
    @Override
    public void transaction(Offre o){
        super.transaction(o);
        ajouterAuStock(o.getProduit());
        System.out.println(" Le produit a été ajouté à votre stock et vous pouvez le revendre");

    }

}