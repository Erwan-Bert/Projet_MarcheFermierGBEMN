package marche.traitement;


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
        ProducteurLaitier producteurLaitier = new ProducteurLaitier(12,"miche miche", 5);
        try {
            uniteDeProductionLaitier.ajouterProducteur(producteurLaitier);
            uniteDeProductionLaitier.ajouterProducteur(new ProducteurDeViande(544445454, "Robert", 1));
        }
        catch (ClassCastException e)
        {
            System.out.println("Le membre que vous avez essayé d'ajouter n'est pas autorisé à vendre le type de produit produite par" +
                    "cette unité de production");
        }
        System.out.println(uniteDeProductionLaitier);

    }



}
