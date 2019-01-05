package Tests;


import marche.traitement.Acteurs.CentraleAchat;
import marche.traitement.FluxInformation.FluxInformation;
import marche.traitement.FluxInformation.NewsLetter;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;
import marche.traitement.UnitedeProduction.UniteDeProduction;
import marche.traitement.UnitedeProduction.UniteDeProductionLaitier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
        //production
        UniteDeProduction u = new UniteDeProductionLaitier("les vaches du futur");
        Producteur p0 = new ProducteurLaitier(200,"Mbappe",100);
        Producteur p1 = new ProducteurLaitier(200,"Riberi",100);
        u.ajouterProducteur(p0);
        u.ajouterProducteur(p1);
        p0.cotiser();
        p1.cotiser();
        u.produire(10,"lait",LocalDate.now().plusDays(10),p0);

        // préparation acheteur
        CentraleAchat c = new CentraleAchat("Metro");
        c.ajouterMembres(p1);
        c.setPourcentage(10);

        //Flux informations
        FluxInformation newsletter = new NewsLetter("adopte un légume");
        newsletter.ajouterAbonne(p1);

        //ajout d'une offre
        p0.creerUneOffre(100,p0.getStocks().get(0));

        //achat
        p1.acheter(LivreDuMarche.getLivre().get(0));

        assertNotEquals(99990,p1.getSolde());





    }
}



