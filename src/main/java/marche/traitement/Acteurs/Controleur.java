package marche.traitement.Acteurs;
import marche.traitement.GestionnaireDeTransaction.GestionnaireDeTransaction;
import marche.traitement.Marche.Archive;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;

import java.time.LocalDate;

/**
 * 
 */
public class Controleur {

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
    public static boolean validerOffre(Offre o) {
        return (o.getPrix() < 1000000); //validation purement arbitraire
    }

    /**
     *
     *  choisis a qui attribuer l'offre en fonction de la liste des acheteurs potentiels
     */
    public static void choisirAcheteur(Offre offre) {
        if(offre.getAcheteurPotentiel().size() != 0) {
            Acteur acheteur = offre.getAcheteurPotentiel().get(0); //arbitrairement
            acheteur.debiter(offre.getPrix());
            LivreDuMarche.enleverOffre(offre);
            GestionnaireDeTransaction.transaction(acheteur, offre);
            HistoriqueOffre.addOffresArchives(new Archive(acheteur, offre, LocalDate.now()));
        }
        //acheteur.ajouter
        //livrerProduit()

    }


    /**
     *
     */
    public static void supprimerOffre(Offre o) {

        o.archiver();
    }

}