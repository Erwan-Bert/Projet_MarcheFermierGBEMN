package Tests;


import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;

import java.time.LocalDate;

public class Test {
    @org.junit.jupiter.api.Test
    public void pomme()
    {
        Produit p = new Pomme(1,LocalDate.now(),"quintal");
        System.out.println(p.getDateDePeremption().toString() + p.getQuantite());
    }

    @org.junit.jupiter.api.Test
    public void uniteDeProd()
    {
        Produit p = new Pomme(1,LocalDate.now(),"quintal");

        assert (p.getQuantite() == 1);
    }
}



