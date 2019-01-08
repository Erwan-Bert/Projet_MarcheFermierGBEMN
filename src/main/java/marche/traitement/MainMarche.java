package marche.traitement;


import marche.traitement.Producteurs.DecorateurProducteur.ProducteurBio;
import marche.traitement.Producteurs.ProducteurDeViande;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.UnitedeProduction.UniteDeProductionApiculteur;
import marche.traitement.UnitedeProduction.UniteDeProductionLaitier;

import java.time.LocalDate;

public class MainMarche {
    public static void main(String[] args)
    {
        LocalDate peremption = LocalDate.of(2015, 8, 11);
        System.out.println(peremption.plusDays(1));
        UniteDeProductionApiculteur uniteDeProductionApiculteur = new UniteDeProductionApiculteur("Les miellistes");
        UniteDeProductionLaitier uniteDeProductionLaitier = new UniteDeProductionLaitier("Les laitiers");
        ProducteurLaitier prod = new ProducteurLaitier(400,"tpo",562);
        ProducteurBio producteurLaitier = new ProducteurBio(new ProducteurLaitier(400,"tpo",562));


        uniteDeProductionLaitier.ajouterMembre(producteurLaitier);
        uniteDeProductionLaitier.ajouterMembre(new ProducteurDeViande(544445454, "Robert", 1));


    }



}
