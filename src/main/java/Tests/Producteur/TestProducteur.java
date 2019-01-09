package Tests.Producteur;

import marche.traitement.Acteurs.ChoixAcheteur.ChoixParOrdreArrivee;
import marche.traitement.Acteurs.controleur.ControleurAMF;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Producteurs.Apiculteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.UnitedeProduction.UniteDeProductionApiculteur;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestProducteur {

    @Test
    public void Produire(){

        Apiculteur apiculteur = new Apiculteur(1500,"JJ",150);
        ProducteurLaitier producteurLaitier = new ProducteurLaitier(450,"GG",500);
        LivreDuMarche livreDuMarche = new LivreDuMarche("LM",new ControleurAMF(new ArrayList<String>()));

        //Produit produit = new Miel(50, LocalDate.MAX,"Pots");
        UniteDeProductionApiculteur UP = new UniteDeProductionApiculteur("TEST");
        UP.ajouterMembre(apiculteur);
        UP.produire(15,"miel",LocalDate.MAX,apiculteur);
        apiculteur.creerUneOffre(450,apiculteur.getElementStock(1),new ChoixParOrdreArrivee(),livreDuMarche,10);


        assert(livreDuMarche.getLivre().get(0).getPrix() == 450);
        assert(livreDuMarche.getLivre().get(0).getVendeur() == apiculteur);
        assert(apiculteur.getStocks().get(0).getQuantite() == 5);
    }
}
