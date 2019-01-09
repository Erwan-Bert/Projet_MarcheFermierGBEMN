package marche.traitement.Acteurs.controleur;
import marche.traitement.Acteurs.Acteur;
import marche.traitement.Marche.Offre;

import java.util.ArrayList;
import java.util.List;

/**
 * Le controleur est chargé de valider les offres, de controler la blaclist qui va être imposé au marché auquel le
 * controleur appartient, il est aussi chargé de choisir l'acheteur parmis un offre et géré la cloture de l'offre
 */
public abstract class Controleur {
    protected List<String> blaclistProduit ;


    public Controleur(ArrayList<String> blaclistProduit) {
        this.blaclistProduit = blaclistProduit;
    }
    public void ajouterALABlacklist(String nom){
        blaclistProduit.add(nom);
    }
    public void retirerALABlacklist(String nom){
        blaclistProduit.remove(nom);
    }
    public String afficherBlacklist(){
        StringBuilder s = new StringBuilder();
        for(String produit : blaclistProduit){
            s.append(produit);
        }
        return s.toString();
    }

    /**
     *
     * @param o offre à valider
     * @return retourne si l'offre a été validé
     */
    public abstract boolean validerOffre(Offre o);
    public abstract String getNom();

    /**
     * choisis a qui attribuer l'offre en fonction de la liste des acheteurs potentiels
     *  Effectue la transaction, enlève l'offre du livre du marché et archivre l'offre
     * @param offre
     */
    public void choisirAcheteur(Offre offre) {
        if(offre.getAcheteurPotentiel().size() != 0) {
            Acteur acheteur = offre.getStrategyChoixAcheteur().choixAcheteur(offre.getAcheteurPotentiel());
            acheteur.transaction(offre);
            offre.archiver();
        }
    }
}