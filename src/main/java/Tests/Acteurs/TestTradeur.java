package Tests.Acteurs;

import marche.traitement.Acteurs.ChoixAcheteur.ChoixParOrdreArrivee;
import marche.traitement.Acteurs.controleur.ControleurAMF;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Producteurs.Horticulteur;
import marche.traitement.Produit.Epinards;
import marche.traitement.Produit.Produit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTradeur {


    @Test
    public void creerUneoffre_Basique(){
        Horticulteur horticulteur = new Horticulteur(800,"Horticulteur",100);
        Produit produit = new Epinards(800, LocalDate.now(),"Pousses");
        LivreDuMarche livreDuMarche = new LivreDuMarche("LM",new ControleurAMF(null));
        Offre offre = new Offre(150,produit,horticulteur,new ChoixParOrdreArrivee(),livreDuMarche);


        livreDuMarche.ajouterOffre(offre);
        System.out.printf(livreDuMarche.getLivre().toString());

        assert(offre.getPrix() == 150);
        assertTrue(livreDuMarche.getLivre().contains(offre));
    }
}
