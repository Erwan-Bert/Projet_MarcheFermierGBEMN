package Tests;

import marche.traitement.UnitedeProduction.UniteDeProduction;
import marche.traitement.UnitedeProduction.UniteDeProductionLaitier;

public class testUniteDeProduction {


    @org.junit.jupiter.api.Test
    public void testProductionBio()
    {
        UniteDeProduction u = new UniteDeProductionLaitier("azer");
/*
        Producteur producteurLaitier = new ProducteurLaitier(100,"Bernard",1500);
        Producteur producteurBio = new ProducteurBio(producteurLaitier);
        UniteDeProductionLaitier ulaitier = new UniteDeProductionLaitier("meu");
        UniteDeProduction u = new UniteDeProductionBio(ulaitier);
        u.ajouterMembre(producteurBio);


        u.produire(10,"lait",LocalDate.now().plusDays(10),producteurBio);
        producteurBio.afficherStock();
        */
    }


}
