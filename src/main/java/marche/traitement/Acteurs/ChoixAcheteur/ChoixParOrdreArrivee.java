package marche.traitement.Acteurs.ChoixAcheteur;

import marche.traitement.Acteurs.Acteur;

import java.util.List;

/**
     *  Classe permettant de choisir l'ordre des Acheteur selon leur date d'arrivee
     */
public class ChoixParOrdreArrivee implements StrategyChoixAcheteur {
    /**
     *
     * @param acheteurPotentiel liste des acheteurs potentiels
     * @return retourne le premier acteur de la liste
     */
    @Override
    public Acteur choixAcheteur(List<Acteur> acheteurPotentiel) {

        return acheteurPotentiel.get(0);
    }
}
