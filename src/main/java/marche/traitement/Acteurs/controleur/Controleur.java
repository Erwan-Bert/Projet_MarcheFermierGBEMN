package marche.traitement.Acteurs.controleur;
import marche.traitement.Acteurs.Acteur;
import marche.traitement.Marche.Archive;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.Offre;

import java.time.LocalDate;

/**
 * 
 */
public abstract class Controleur {

    /**
     * Default constructor
     */


    public Controleur() {
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