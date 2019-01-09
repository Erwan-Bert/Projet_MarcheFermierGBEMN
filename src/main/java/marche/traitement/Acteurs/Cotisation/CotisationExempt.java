package marche.traitement.Acteurs.Cotisation;

    /**
	 * Le calcul de cotisation exempte de paiment
     */
public class CotisationExempt extends StrategyCotisation {

    @Override
    protected int calculCotisation(int montant) {
        return 0;
    }
}
