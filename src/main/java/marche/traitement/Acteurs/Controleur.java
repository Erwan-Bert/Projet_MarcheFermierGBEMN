package marche.traitement.Acteurs;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

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
     * @param Offre
     * @return bool
     */
    public boolean validerOffre(Offre o) {
        return (o.getPrix() < 1000000); //validation purement arbitraire
    }

    /**
     * @param Offre
     *  choisis a qui attribuer l'offre en fonction de la liste des acheteurs potentiels
     */
    public void choisirAcheteur(Offre o) {
        Acteur acheteur = o.getAcheteurPotentiel().get(0);
        acheteur.debiter(o.getPrix());
        /*if(acheteur instanceof VendeurAcheteur){
            acheteur.
        } */


    }

    private void fairePayerAcheteur(Acteur acheteur, Produit produit){}

    /**
     * @param Offre
     */
    public void supprimerOffre(Offre o) {

        o.archiver();
    }

}