package marche.traitement.Acteurs;
import marche.traitement.Marche.Offre;

import java.util.*;

/**
 * 
 */
public class Acteur {

    public Acteur(){}

    public Acteur(double solde, String nom) {
        this.solde = solde;
        this.nom = nom;
        this.dateFinCotisation = "01/01/2000";
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

    public String getDateFinCotisation() {
        return dateFinCotisation;
    }

    protected void setDateFinCotisation(String dateFinCotisation) {
        this.dateFinCotisation = dateFinCotisation;
    }

    /**
     * 
     */
    private double solde;
    private String nom;
    /**
     * 
     */
    private String dateFinCotisation;


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