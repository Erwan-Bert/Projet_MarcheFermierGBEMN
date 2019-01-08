package Tests.Produit;

import marche.traitement.Produit.Miel;
import marche.traitement.Produit.Produit;

import java.time.LocalDate;

public class TestProduit {
    @org.junit.jupiter.api.Test
    public void test()
    {
        Miel miel = new Miel(5, LocalDate.MAX,"");
        Produit mazer = miel.clone();
        mazer.setQuantite(4);
        System.out.println(mazer.getQuantite() +"  "+ miel.getQuantite());



    }
}
