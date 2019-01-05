package Tests;


import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;
import marche.traitement.UnitedeProduction.UniteDeProduction;
import marche.traitement.UnitedeProduction.UniteDeProductionLaitier;

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
        UniteDeProduction u = new UniteDeProductionLaitier("les vaches du futur");
        Producteur p0 = new ProducteurLaitier(10000,"Mbappe",100);
        Producteur p1 = new ProducteurLaitier(10000,"Riberi",100);
        u.ajouterProducteur(p0);
        u.ajouterProducteur(p1);
        u.produire(10,"lait",LocalDate.now().plusDays(10));

    }
}



