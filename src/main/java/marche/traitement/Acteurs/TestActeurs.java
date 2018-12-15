package marche.traitement.Acteurs;

import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;

import java.time.LocalDate;

public class TestActeurs {
    public static void main(String[] args) {

        Acteur acteur = new Acteur(10000,"Jacob");
        Produit pomme = new Pomme(4,LocalDate.now(),"Tonne");
        Offre offre = new Offre(15000,3,pomme);

    }
}