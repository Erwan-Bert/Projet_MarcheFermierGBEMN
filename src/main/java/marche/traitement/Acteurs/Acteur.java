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

    public void setSolde(double solde) {
        this.solde = solde;
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
     * @param Offre
     * @return
     */
    public boolean acheter(Offre o) {
        if( o.getPrix() < solde){
            setSolde( solde - o.getPrix());
            o.addAcheteurPotentiel(this);
            return true;
        }
        return false;
    }

}