package marche.traitement.Acteurs;

import marche.traitement.Acteurs.ChoixAcheteur.StrategyChoixAcheteur;
import marche.traitement.Initialisation.Initialisation;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public  class VendeurAcheteur extends Acteur {


    protected List<Produit> stocks = new ArrayList<Produit>();
    public List<Produit> getStocks() {
        return stocks;
    }

    /**
     * Default constructor
     */
    public VendeurAcheteur(double solde, String nom)
    {
        super(solde, nom);
        Initialisation.listeVendeurAcheteur.add(this);
    }
    public VendeurAcheteur() {
    }


    /**
	 * Creer une offre selon le prix et le Produit (vend tout le produit)
     * @param //int quantite
     * @param //int prix
     * @param //Produit produit
     * @return
     */
    public void creerUneOffre(int prix, Produit produit, StrategyChoixAcheteur strategyChoixAcheteur, LivreDuMarche marche)throws ArithmeticException,IllegalArgumentException {

        try {
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
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    /**
     * Creer une offre selon la quantité le prix et le Produit
     * @param //int quantite
     * @param //int prix
     * @param //Produit produit
     * @return
     */

    public void creerUneOffre(int prix, Produit produit, StrategyChoixAcheteur strategyChoixAcheteur, LivreDuMarche marche,int quantite)throws ArithmeticException,IllegalArgumentException
    {
        try
        {
            if(prix<0)
                throw new ArithmeticException("prix négatif");
            if(produit == null)
                throw new IllegalArgumentException("rentrez un produit valide");
            if (stocks.contains(produit) && quantite < produit.getQuantite())
            {
                Produit copy = produit.clone();
                copy.setQuantite(quantite);
                Offre offre = new Offre(prix,copy,this,strategyChoixAcheteur,marche);
                if (marche.getControleur().validerOffre(offre))
                {
                    produit.setQuantite(produit.getQuantite()-quantite);
                    marche.ajouterOffre(offre);
                }
                else
                    throw new IllegalArgumentException("votre offre a été rejeté par l'amf");
            }
            else
            {
                throw new IllegalArgumentException("rentrez un produit vali");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
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
            if(     stock.getNom().equals(produit.getNom()) &&
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
     * @param
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
    public String afficherStock()
    {
        int compteur = 1;
        StringBuilder contenuStock = new StringBuilder();
        if (stocks.size() != 0)
        {
            for (Produit produit : stocks) {
                contenuStock.append(") " + produit.getQuantite() + " kilo de " + produit.getNom() + " / périme le : " + produit.getDateDePeremption());
                compteur++;
            }
        }
        else
            contenuStock.append("vide");
        return contenuStock.toString();
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