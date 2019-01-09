package marche.traitement.Acteurs.Cotisation;

public class CotisationMoitierPrix extends  StrategyCotisation {
    /**
     *
     * @param montant de la cotisation
     * @return retourne la moitié du montant
     */
    @Override
   protected int calculCotisation(int montant) {
        return (int)(0.5*montant);
    }
}
