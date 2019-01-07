package marche.traitement.Acteurs.Cotisation;

/**
	 * Classe de strategie de cotisation Plein Pot 
     */
public class CotisationPleinPot implements StrategyCotisation {
    @Override
    public int calculCotisation() {
        return 300;
    }
}
