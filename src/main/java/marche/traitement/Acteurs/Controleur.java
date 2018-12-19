package marche.traitement.Acteurs;
import marche.traitement.Marche.Archive;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

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
    public boolean validerOffre(Offre o) {
        return (o.getPrix() < 1000000); //validation purement arbitraire
    }

    /**
     *
     *  choisis a qui attribuer l'offre en fonction de la liste des acheteurs potentiels
     */
    public void choisirAcheteur(Offre o) {
        Acteur acheteur = o.getAcheteurPotentiel().get(0); //arbitrairement
        acheteur.debiter(o.getPrix());
        LivreDuMarche.enleverOffre(o);
        HistoriqueOffre.addOffresArchives(new Archive(acheteur,o, LocalDate.now()));
        //acheteur.ajouter
        //livrerProduit()

    }





    private void fairePayerAcheteur(Acteur acheteur, Produit produit){}

    /**
     *
     */
    public void supprimerOffre(Offre o) {

        o.archiver();
    }

}