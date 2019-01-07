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

    public LivreDuMarche getMarche() {
        return marche;
    }

    private LivreDuMarche marche;
    public StrategyChoixAcheteur getStrategyChoixAcheteur() {
        return strategyChoixAcheteur;
    }

    private StrategyChoixAcheteur strategyChoixAcheteur;



    public VendeurAcheteur getVendeur() {
        return vendeur;
    }




    /**
     * Default constructor
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
     * Ajoute a la liste des archives une archive avec l'offre et la date du jour 
     */
    public void archiver() {
        HistoriqueOffre.addOffresArchives( new Archive(null, this,LocalDate.now()));
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
	 * @param Acteur acheteurPotentiel
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
        StringBuilder s = new StringBuilder("Offre : " +produit.getQuantite() + produit.getUnite());
        s.append(produit.getNom());
        s.append(" à ");
        s.append(prix);
        s.append("  et qui périme le ");
        s.append(produit.getDateDePeremption());

        return s.toString();
    }
}