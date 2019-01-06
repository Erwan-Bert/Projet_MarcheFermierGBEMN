package marche.traitement.Acteurs.Cotisation;

public class CotisationExempt implements StrategyCotisation {
    @Override
    public int calculCotisation() {
        return 0;
    }
}
