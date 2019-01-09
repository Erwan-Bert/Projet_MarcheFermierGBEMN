package marche.traitement.Marche;

import marche.traitement.Acteurs.Acteur;

import java.time.LocalDate;

public class Archive
{
    private Acteur acheteur;
    private Offre offre;
    private LocalDate date;

    /**
     * permet d'instancier une Archive
     * @param acheteur Acteur correspondant à l'acheteur
     * @param offre Offre correspondant à l'achat effectué
     * @param date Date correspondant à la date au moment de l'achat
     */
    public Archive (Acteur acheteur, Offre offre,LocalDate date)
    {
        this.acheteur =acheteur;
        this.offre = offre;
        this.date = date;
    }

	/**
     * Retourne l'acheteur de l'archive
	 * @return acheteur
     */
    public Acteur getAcheteur() {
        return acheteur;
    }

	/**
     * Retourne l'offre de l'archive
	 * @return offre
     */
    public Offre getOffre() {
        return offre;
    }
	
	/**
     * Retourne la date de l'archive
	 * @return date
     */
    public LocalDate getDate() {
        return date;
    }


    /**
     * permet de faciliter l'affichage d'une archive à travers une string
     * @return string
     */
    @Override
    public String toString() {
        return "Archive{" +
                "acheteur=" + acheteur.getNom() +
                ", " + offre +
                ", acheté le " + date +
                "}\n";
    }
}
