package marche.traitement.Acteurs.Cotisation;

/**
	 * Permet de calculer la valeur de la cotisation selon la strategie
     */
public abstract class StrategyCotisation {

    static final  int coutCotisation = 300;
    /**
     * Les deux méthodes sont utilisé pour pouvoir appeler des strategie de cotisation à la chaine
     * dans Ensemble de Cotisation
     */


    /**
     *
     * @return cout de cotisation donné par la classe
     */
    public int  calculCotisation(){
        return calculCotisation(coutCotisation);
    }

    /**
     *
     * @param montant de la cotisation
     * @return montant de la cotisation après modification par la strategy
     */
    abstract int calculCotisation(int montant);
}
