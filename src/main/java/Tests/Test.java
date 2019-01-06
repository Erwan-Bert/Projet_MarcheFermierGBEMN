package Tests;


import marche.traitement.Acteurs.CentraleAchat;
import marche.traitement.Acteurs.Controleur;
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
        Producteur vendeur = new ProducteurLaitier(200,"claude",100);
        Producteur acheteur = new ProducteurLaitier(200,"solaar",100);
        u.ajouterProducteur(vendeur);
        u.ajouterProducteur(acheteur);
        vendeur.cotiser();
        acheteur.cotiser();
        u.produire(10,"lait",LocalDate.now().plusDays(10),vendeur);

        // préparation acheteur
        CentraleAchat c = new CentraleAchat("Metro");
        c.ajouterMembres(acheteur);
        c.setPourcentage(10);

        //Flux informations
        FluxInformation newsletter = new NewsLetter("adopte un légume");
        newsletter.ajouterAbonne(acheteur);

        //ajout d'une offre
        vendeur.creerUneOffre(100,vendeur.getStocks().get(0));

        LivreDuMarche.afficherLivre();

        //achat
        acheteur.acheter(LivreDuMarche.getLivre().get(0));
        Controleur.choisirAcheteur(LivreDuMarche.getLivre().get(0));
        LivreDuMarche.afficherLivre();

        assertEquals(110,acheteur.getSolde());





    }
}



