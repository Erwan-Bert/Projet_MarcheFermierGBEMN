package marche.traitement.Acteurs.Cotisation;

    /**
	 * Classe de strategie de cotisation Plein Pot 
     */
public class CotisationPleinPot extends StrategyCotisation {
    /**
     *
     * @param montant de la cotisation
     * @return la totalité du montant
     */
    @Override
    protected int calculCotisation(int montant) {
        return montant;
    }
}
