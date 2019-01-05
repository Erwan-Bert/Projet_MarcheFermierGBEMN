package marche.traitement.Marche;

import marche.traitement.Acteurs.Acteur;
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

        }





    /**
     * Function archiver
     */
    public void archiver() {
        HistoriqueOffre.addOffresArchives( new Archive(null, this,LocalDate.now()));
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