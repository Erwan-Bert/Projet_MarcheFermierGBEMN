package marche.traitement.Acteurs.ChoixAcheteur;

import marche.traitement.Acteurs.Acteur;

import java.util.ArrayList;

public class ChoixParPlusPetitSolde implements StrategyChoixAcheteur {
    @Override
    public Acteur choixAcheteur(ArrayList<Acteur> acheteurPotentiel) {
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
