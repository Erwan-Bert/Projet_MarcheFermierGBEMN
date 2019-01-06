package marche.traitement.Acteurs;
import marche.traitement.Marche.Archive;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;

import java.time.LocalDate;

/**
 * 
 */
public final class Controleur {

    /**
     * Default constructor
     */
    private Controleur() {
    }


    /**
     * valide l'offre si les conditions sont respectés
     *
     * @return bool
     */
    public static boolean validerOffre(Offre o) {
        return (o.getPrix() < 1000000); //validation purement arbitraire
    }

    /**
     *
     *  choisis a qui attribuer l'offre en fonction de la liste des acheteurs potentiels
     *  Effectue la transaction, enlève l'offre du livre du marché et archivre l'offre
     */
    public static void choisirAcheteur(Offre offre) {
        if(offre.getAcheteurPotentiel().size() != 0) {
            Acteur acheteur = offre.getAcheteurPotentiel().get(0); //arbitrairement
            LivreDuMarche.enleverOffre(offre);
            acheteur.transaction(offre);
            HistoriqueOffre.addOffresArchives(new Archive(acheteur, offre, LocalDate.now()));
        }
    }


    public static void supprimerOffre(Offre o) {

        o.archiver();
    }

}