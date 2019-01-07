package marche.traitement.Acteurs.ChoixAcheteur;

import marche.traitement.Acteurs.Acteur;

import java.util.ArrayList;

/**
     *  Permet de choisir la strategie de renvoie des acheteurs
     */
public interface StrategyChoixAcheteur
{
    Acteur choixAcheteur(ArrayList<Acteur> acheteurPotentiel);
}
