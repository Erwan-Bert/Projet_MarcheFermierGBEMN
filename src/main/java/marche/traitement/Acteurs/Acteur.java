package marche.traitement.Acteurs;
import marche.traitement.Marche.Offre;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
public class Acteur {
    /**
     *
     */
    private double solde;
    private String nom;
    /**
     *
     */
    private LocalDate dateFinCotisation;

    public Acteur(){}

    public Acteur(double solde, String nom) {
        this.solde = solde;
        this.nom = nom;
        this.dateFinCotisation = LocalDate.MIN;
    }




    public boolean cotiser(){

        if( solde > 100){
            debiter(100);
            dateFinCotisation = LocalDate.now();
            ajouterJoursDateFinCotisation(365);
            return true;
        }
        return false;
    }

    public boolean aCotiser(){
        return (this.dateFinCotisation.isAfter(LocalDate.now()));
    }

    protected void setDateFinCotisation(LocalDate dateFinCotisation) {
        this.dateFinCotisation = dateFinCotisation;
    }

    public void ajouterJoursDateFinCotisation(int nbjours){
        this.dateFinCotisation = dateFinCotisation.plusDays(nbjours);
    }


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


    public LocalDate getDateFinCotisation() {
        return dateFinCotisation;
    }
    public double getSolde() {
        return solde;
    }
    public void crediter(double montant){
        this.solde += montant;
    }
    public void debiter(double montant){
        this.solde -= montant;
    }
}