package marche.traitement.Acteurs.ChoixAcheteur;

import marche.traitement.Acteurs.Acteur;

import java.util.ArrayList;

	/**
     *  Classe permettant de choisir l'ordre des Acheteur selon leur date d'arrivee
     */
public class ChoixParOrdreArrivee implements StrategyChoixAcheteur {
    @Override
    public Acteur choixAcheteur(ArrayList<Acteur> acheteurPotentiel) {

        return acheteurPotentiel.get(0);
    }
}
