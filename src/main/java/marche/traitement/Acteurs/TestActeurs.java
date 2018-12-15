package marche.traitement.Acteurs;

import java.time.LocalDate;

public class TestActeurs {
    public static void main(String[] args) {

        Acteur acteur = new Acteur(10000,"Jacob");
        System.out.println(acteur.cotiser());
        System.out.println(acteur.getSolde());
        System.out.println(acteur.getDateFinCotisation());
        System.out.println(acteur.aCotiser());

    }
}