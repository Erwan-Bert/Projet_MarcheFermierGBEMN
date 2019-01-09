package Tests.Cotisation;

import marche.traitement.Acteurs.Cotisation.CotisationMoitierPrix;
import marche.traitement.Acteurs.Cotisation.CotisationPleinPot;
import marche.traitement.Acteurs.Cotisation.EnsembleCotisation;
import marche.traitement.Acteurs.Cotisation.StrategyCotisation;

import static org.junit.jupiter.api.Assertions.*;

public class TestCotisation {

    @org.junit.jupiter.api.Test
    public void EnsembleCalculCotisation() {
        StrategyCotisation c = new CotisationPleinPot();
        StrategyCotisation demi = new CotisationMoitierPrix();
        EnsembleCotisation ensemble = new EnsembleCotisation();
        ensemble.ajouterSTrategyCotisation(demi);
        ensemble.ajouterSTrategyCotisation(c);

        assertEquals(150,ensemble.calculCotisation());

    }
}
