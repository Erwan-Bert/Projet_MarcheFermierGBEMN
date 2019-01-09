package marche.traitement.Marche;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Acteurs.ChoixAcheteur.StrategyChoixAcheteur;
import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Produit.Produit;

import java.time.LocalDate;
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
    private LivreDuMarche marche;
    private StrategyChoixAcheteur strategyChoixAcheteur;
    public VendeurAcheteur getVendeur() {
        return vendeur;
    }


    /**
     * Permet d'instancier une offre
     * @param prix int correspondant au prix de l'offre
     * @param produit Produit correspondant à la marchandise à venre
     * @param vendeurAcheteur Acteur correspondant au vendeur de la marchandise
     * @param strategyChoixAcheteur Strategie permettant de choisisr la manière de selectionner l'acheteur
     * @param marche Correspond au marche dans lequel l'offre sera disponible
     */
    public Offre(int prix, Produit produit, VendeurAcheteur vendeurAcheteur,StrategyChoixAcheteur strategyChoixAcheteur,
                 LivreDuMarche marche)
    {
        this.prix = prix;
        this.produit = produit;
        this.vendeur = vendeurAcheteur;
        this.strategyChoixAcheteur = strategyChoixAcheteur;
        this.marche = marche;
        }


    /**
     * methode permettant de retirer l'offre elle-même dumarché où elle se trouve
     */
    public void retirerOffre()
    {
        marche.getLivre().remove(this);
    }

    /**
     * méthode permettant d'obtenir La strategie de vente souhaité par le vendeur
     * @return strategie de choix d'acheteur
     */
    public StrategyChoixAcheteur getStrategyChoixAcheteur()
    {
        return strategyChoixAcheteur;
    }

    public LivreDuMarche getMarche()
    {
        return marche;
    }
    /**
     * Ajoute a la liste des archives une archive avec l'offre et la date du jour 
     */
    public void archiver() {
        HistoriqueOffre.addOffresArchives( new Archive(null, this, LocalDate.now()));
        retirerOffre();
    }
	
	/**
     * Retourne le prix de l'offre
	 * @return int
     */
    public int getPrix() {
        return prix;
    }

	/**
     * Retourne la valider de l'offre Oui/Non
	 * @return boolean
     */
    public boolean isValider() {
        return valider;
    }

	/**
     * Valider une offre
     */
    public void validerOffre()
    {
        this.valider = true;
    }

	/**
     * Retourne le produit de l'offre
	 * @return produit
     */
    public Produit getProduit() {
        return produit;
    }

	/**
     * Retourne la liste des acheteurs potentiels
	 * @return acheteurPotentiel
     */
    public List<Acteur> getAcheteurPotentiel() {
        return acheteurPotentiel;
    }

	/**
     * Ajoute un acheteur a la liste des acheteurs potentiels
	 * @param  acheteurPotentiel Acteur correspondant à l'acheteur potentiel
     */
    public void addAcheteurPotentiel(Acteur acheteurPotentiel) {
        this.acheteurPotentiel.add(acheteurPotentiel);
    }

	/**
     * Retourne tout le detail d'une offre avec le nom du produit le prix et la date de peremption
	 * @return toString
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(" Offre : " + produit.getQuantite() + " " + produit.getUnite() + " ");
        s.append(produit.getNom());
        s.append(" à ");
        s.append(prix + "€");
        s.append(" et qui périme le ");
        s.append(produit.getDateDePeremption());
        s.append('\n');
        return s.toString();
    }
}