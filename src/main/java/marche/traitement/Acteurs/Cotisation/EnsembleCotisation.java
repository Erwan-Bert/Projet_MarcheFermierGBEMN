package marche.traitement.Acteurs.Cotisation;

import java.util.ArrayList;

/**
 * Permet d'appliquer plusieurs stratedie en même temps
 */
public class EnsembleCotisation extends StrategyCotisation{
    private ArrayList<StrategyCotisation> strategyCotisations = new ArrayList<StrategyCotisation>();

    public EnsembleCotisation() {}

    /**
     *
     * @return la cotisation de base changé par chaque Strategie de l'attribut strategyCotisations
     */
    @Override
    public int calculCotisation() {
        int cotisation = coutCotisation;
        for(StrategyCotisation strategyCotisation : strategyCotisations){
           cotisation = strategyCotisation.calculCotisation(cotisation);
        }
        return cotisation;
    }

    /**
     * se contente d'appeller calculCotisation
     * @param montant de la cotisation
     * @return même chose que calculCotisation
     */
    @Override
    protected int calculCotisation(int montant) {
        return calculCotisation();
    }

    public void ajouterSTrategyCotisation(StrategyCotisation strategyCotisation){
        strategyCotisations.add(strategyCotisation);
    }
}
