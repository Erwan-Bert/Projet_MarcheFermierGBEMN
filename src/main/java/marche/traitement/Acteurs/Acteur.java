package marche.traitement.Acteurs;
import marche.traitement.Marche.Offre;

import java.util.*;

/**
 * 
 */
public class Acteur {

    /**
     * Default constructor
     */
    public Acteur(double solde) {
    }

    public double getSolde() {
        return solde;
    }
    public void crediter(double montant){
        this.solde += montant;
    }
    public void debiter(double montant){
        this.solde += montant;
    }

    public Date getDateFinCotisation() {
        return dateFinCotisation;
    }

    protected void setDateFinCotisation(Date dateFinCotisation) {
        this.dateFinCotisation = dateFinCotisation;
    }

    /**
     * 
     */
    private double solde;

    /**
     * 
     */
    private Date dateFinCotisation;


    /**
     * @param //Offre
     * @return
     */
    public boolean acheter(Offre o) {
        if( o.getPrix() <= solde){
            debiter(o.getPrix());
            o.addAcheteurPotentiel(this);
            return true;
        }
        return false;
    }

}