package marche.traitement.Acteurs.Cotisation;

/**
	 * Classe de strategie de cotisation Exempt
     */
public class CotisationExempt implements StrategyCotisation {
    @Override
    public int calculCotisation() {
        return 0;
    }
}
