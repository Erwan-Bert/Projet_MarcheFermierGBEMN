package marche.traitement.Acteurs;

public class CotisationPleinPot implements StrategyCotisation {
    @Override
    public int calculCotisation() {
        return 300;
    }
}
