package marche.traitement.Acteurs.ChoixAcheteur;

import marche.traitement.Acteurs.Acteur;

import java.util.List;

/**
     *  Classe permettant de choisir l'ordre des Acheteur par ordre croissant du solde (plus petit solde)
     */
public class ChoixParPlusPetitSolde implements StrategyChoixAcheteur {

    /**
     *
     * @param acheteurPotentiel liste des acheteurs potentiels
     * @return retourne l'acheteur ayant le plus petit solde dans acheteurPotentiel
     */
    @Override
    public Acteur choixAcheteur(List<Acteur> acheteurPotentiel) {
        Acteur acheteurChoisi = acheteurPotentiel.get(0);
        for (int i = 1; i< acheteurPotentiel.size() - 1;++i)
        {
            if (acheteurChoisi.getSolde() > acheteurPotentiel.get(i).getSolde())
            {
                acheteurChoisi = acheteurPotentiel.get(i);
            }


        }
        return acheteurChoisi;
    }
}
