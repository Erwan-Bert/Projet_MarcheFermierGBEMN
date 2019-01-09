package marche.traitement.Acteurs.Cotisation;

import java.util.ArrayList;

public class EnsembleCotisation extends StrategyCotisation{
    private ArrayList<StrategyCotisation> strategyCotisations = new ArrayList<StrategyCotisation>();

    public EnsembleCotisation() {

    }

    /**
     *
     * @return la cotisation de base changé par chaque Strategie de cotisation
     */
    @Override
    public int calculCotisation() {
        int cotisation = coutCotisation;
        for(StrategyCotisation strategyCotisation : strategyCotisations){
           cotisation = strategyCotisation.calculCotisation(cotisation);
        }
        return cotisation;
    }

    @Override
    public int calculCotisation(int montant) {
        return calculCotisation();
    }

    public void ajouterSTrategyCotisation(StrategyCotisation strategyCotisation){
        strategyCotisations.add(strategyCotisation);
    }
}
