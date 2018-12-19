package marche.traitement.Acteurs;
import marche.traitement.Marche.Offre;

import java.time.LocalDate;

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



    /**
    *fait payer l'utilisateur et lui ajoute un nombre de jour sur sa période de cotisation
     * retourne si la cotisation a été un succès
     */
    public boolean cotiser(){

        if( solde > 100){
            debiter(100);
            if( dateFinCotisation.isBefore(LocalDate.now()))
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
    public void acheter(Offre o) {
        o.addAcheteurPotentiel(this);
    }


    public LocalDate getDateFinCotisation() {
        return dateFinCotisation;
    }
    public double getSolde() {
        return solde;
    }
    public String getNom() {
        return nom;
    }
    public void crediter(double montant){
        this.solde += montant;
    }
    public void debiter(double montant){
        this.solde -= montant;
    }
}