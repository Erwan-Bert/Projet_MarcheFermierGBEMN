package marche.traitement.Acteurs.ChoixAcheteur;

import marche.traitement.Acteurs.Acteur;

import java.util.ArrayList;

public interface StrategyChoixAcheteur
{
    Acteur choixAcheteur(ArrayList<Acteur> acheteurPotentiel);
}
