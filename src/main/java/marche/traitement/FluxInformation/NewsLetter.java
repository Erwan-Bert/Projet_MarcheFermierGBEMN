package marche.traitement.FluxInformation;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Marche.Offre;

public class NewsLetter extends FluxInformation{

	/**
     * Constructeur de la Boitte aux lettres
	 * @param nom nom de la boite aux lettres
     */
    public NewsLetter(String nom) {
        super(nom);
    }


    /**
     * permet de mettre à jour l'offre et d'envoyer aux abonnés une notification
     * @param offre l'offre mise à jour
     */
    @Override
    public void update(Offre offre) {
        for(Acteur a: this.abonnes)
        System.out.println("envoie d'un mail à " + a.getNom() + "au sujet de" + offre);
    }
}
