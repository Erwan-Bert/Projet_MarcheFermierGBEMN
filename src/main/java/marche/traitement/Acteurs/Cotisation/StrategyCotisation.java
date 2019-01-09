package marche.traitement.Acteurs.Cotisation;

/**
	 * Permet de calculer la valeure de la cotisation selon la strategie
     */
public interface StrategyCotisation {
    int coutCotisation = 300;

    int calculCotisation();
}
