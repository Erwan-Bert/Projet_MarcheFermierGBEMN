package marche.traitement.Acteurs.Cotisation;

/**
	 * Classe de strategie de cotisation Exempt
     */
public class CotisationExempt extends StrategyCotisation {

    @Override
    int calculCotisation(int montant) {
        return 0;
    }
}
