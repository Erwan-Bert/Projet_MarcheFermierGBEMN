package Tests.Marche;

import marche.traitement.Acteurs.ChoixAcheteur.ChoixParOrdreArrivee;
import marche.traitement.Acteurs.controleur.ControleurAMF;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Producteurs.Apiculteur;
import marche.traitement.Produit.Miel;
import marche.traitement.Produit.Produit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestOffre {
    @Test public void offre(){

        Apiculteur apiculteur = new Apiculteur(5570,"Francois",150);
        Produit produit = new Miel(150, LocalDate.MAX,"Pots");
        LivreDuMarche livreDuMarche = new LivreDuMarche("LM",new ControleurAMF(null));

        Offre offre = new Offre(450,produit,apiculteur,new ChoixParOrdreArrivee(),livreDuMarche);

        assert(offre.getPrix() == 450);
        assert(offre.getProduit() == produit);
        assert(offre.getVendeur() == apiculteur);

    }
}
