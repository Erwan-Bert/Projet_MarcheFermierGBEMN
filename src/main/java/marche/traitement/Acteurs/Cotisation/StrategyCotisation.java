package marche.traitement.Acteurs.Cotisation;

/**
 * Permet de calculer la valeur de la cotisation selon la strategie.
 * Les deux méthodes de la classe sont utilisées pour pouvoir appeler des strategies de cotisation à la chaine
 * dans Ensemble de Cotisation
     */
public abstract class StrategyCotisation {

    static final  int coutCotisation = 300;

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
    protected abstract int calculCotisation(int montant);
}
