package marche.traitement.Acteurs.Cotisation;

public class CotisationPleinPot implements StrategyCotisation {
    @Override
    public int calculCotisation() {
        return 300;
    }
}
