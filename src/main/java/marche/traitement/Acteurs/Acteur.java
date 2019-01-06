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
    private CentraleAchat membre = null;
    private StrategyCotisation cotisation = new CotisationPleinPot();
    /**
     *
     */
    private LocalDate dateFinCotisation;

    public Acteur() {
    }

    public Acteur(double solde, String nom) {
        this.solde = solde;
        this.nom = nom;
        this.dateFinCotisation = LocalDate.MIN;
    }


    /**
     * fait payer l'utilisateur et lui ajoute un nombre de jour sur sa période de cotisation
     * retourne si la cotisation a été un succès
     */
    public boolean cotiser() {

        if (solde  > cotisation.calculCotisation()) {
            debiter(cotisation.calculCotisation());
            if (dateFinCotisation.isBefore(LocalDate.now()))
                dateFinCotisation = LocalDate.now();
            ajouterJoursDateFinCotisation(365);
            return true;
        }
        return false;
    }

    public boolean aCotiser() {
        return (this.dateFinCotisation.isAfter(LocalDate.now()));
    }

    protected void setDateFinCotisation(LocalDate dateFinCotisation) {
        this.dateFinCotisation = dateFinCotisation;
    }

    public void ajouterJoursDateFinCotisation(int nbjours) {
        this.dateFinCotisation = dateFinCotisation.plusDays(nbjours);
    }


    /**
     * @param //Offre
     * @return
     */
    public void acheter(Offre o) {
        if(o.getPrix()<solde)
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

    public void crediter(double montant) {
        this.solde += montant;
    }

    public void debiter(double montant) {
        this.solde -= montant;
    }

    protected void setCentraleAchat(CentraleAchat ca) {
        membre = ca;
    }

    public CentraleAchat getCentraleAchat() {
        return membre;
    }

    public void switchStrategyCotisation(StrategyCotisation strategy)
    {
        cotisation = strategy;
    }
}