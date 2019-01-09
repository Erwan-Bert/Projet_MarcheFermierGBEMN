package marche.traitement.Acteurs.controleur;
import marche.traitement.Acteurs.Acteur;
import marche.traitement.Marche.Archive;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.Offre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 
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
     * valide l'offre si les conditions sont respectés
     *
     * @return bool
     */
    public abstract boolean validerOffre(Offre o);
    public abstract String getNom();

    /**
     *
     *  choisis a qui attribuer l'offre en fonction de la liste des acheteurs potentiels
     *  Effectue la transaction, enlève l'offre du livre du marché et archivre l'offre
     */
    public void choisirAcheteur(Offre offre) {
        if(offre.getAcheteurPotentiel().size() != 0) {
            Acteur acheteur = offre.getStrategyChoixAcheteur().choixAcheteur(offre.getAcheteurPotentiel());
            acheteur.transaction(offre);
            HistoriqueOffre.addOffresArchives(new Archive(acheteur, offre, LocalDate.now()));
            offre.retirerOffre();
        }
    }
}