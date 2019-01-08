package marche.traitement;


import marche.traitement.Producteurs.DecorateurProducteur.ProducteurBio;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.UnitedeProduction.UniteDeProductionLaitier;
import marche.traitement.UnitedeProduction.UnitedeProdLabel.UniteDeProductionBio;

public class MainMarche {
    /*public static void main(String[] args)
    {
        LocalDate peremption = LocalDate.of(2015, 8, 11);
        System.out.println(peremption.plusDays(1));
        UniteDeProductionApiculteur uniteDeProductionApiculteur = new UniteDeProductionApiculteur("Les miellistes");
        UniteDeProductionLaitier uniteDeProductionLaitier = new UniteDeProductionLaitier("Les laitiers");
        ProducteurLaitier prod = new ProducteurLaitier(400,"tpo",562);
        ProducteurBio producteurLaitier = new ProducteurBio(new ProducteurLaitier(400,"tpo",562));


        uniteDeProductionLaitier.ajouterMembre(producteurLaitier);
        uniteDeProductionLaitier.ajouterMembre(new ProducteurDeViande(544445454, "Robert", 1));


    }*/

    public static void main(String[] args)
    {
        Producteur grop =new ProducteurLaitier(800,"bite",500);
        Producteur boloss = new ProducteurBio(new ProducteurLaitier(400,"yolo",500));
        UniteDeProductionLaitier up1 = new UniteDeProductionLaitier("yolo");
        UniteDeProductionBio up =new UniteDeProductionBio(up1);
        System.out.println(boloss.getClass());
        up.ajouterMembre(boloss);
        up.ajouterMembre(grop);

    }



}
