package Tests;

import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;
import marche.traitement.UnitedeProduction.UniteDeProduction;

import java.time.LocalDate;

public class testUniteDeProduction {
    @org.junit.jupiter.api.Test
    public void testDeProductionPuisVente()
    {
        Produit produitInitial = new Pomme(10, LocalDate.MAX,"kilo");
        UniteDeProduction.scinderProduit(produitInitial, 6);

    }
}
