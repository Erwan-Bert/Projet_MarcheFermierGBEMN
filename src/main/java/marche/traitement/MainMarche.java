package marche.traitement;


import marche.affichage.AffichageTerminal;
import marche.traitement.Initialisation.Initialisation;

public class MainMarche {

    public static void main(String[] args)
    {   Initialisation.init();
        while (true) {

            AffichageTerminal.gestionMenuPricipal();
        }
    }



}
