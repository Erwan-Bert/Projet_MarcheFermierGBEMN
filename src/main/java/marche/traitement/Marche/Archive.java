package marche.traitement.Marche;

import marche.traitement.Acteurs.Acteur;

import java.time.LocalDate;

public class Archive
{
    private Acteur acheteur;
    private Offre offre;
    private LocalDate date;

    public Archive (Acteur acheteur, Offre offre,LocalDate date)
    {
        this.acheteur =acheteur;
        this.offre = offre;
        this.date = date;
    }

    public Acteur getAcheteur() {
        return acheteur;
    }


    public Offre getOffre() {
        return offre;
    }

    public LocalDate getDate() {
        return date;
    }
}
