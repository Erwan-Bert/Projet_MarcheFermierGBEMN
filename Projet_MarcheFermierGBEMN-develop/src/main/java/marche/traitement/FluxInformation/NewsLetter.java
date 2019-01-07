package marche.traitement.FluxInformation;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Marche.Offre;

public class NewsLetter extends FluxInformation{

	/**
     * Constructeur de la Boitte aux lettres
	 * @param String nom
     */
    public NewsLetter(String nom) {
        super(nom);
    }




    @Override
    public void update(Offre offre) {
        for(Acteur a: this.abonnes)
        System.out.println("envoie d'un mail à " + a.getNom() + "au sujet de" + offre);
    }
}
