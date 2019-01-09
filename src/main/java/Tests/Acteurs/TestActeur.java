package Tests.Acteurs;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Acteurs.ChoixAcheteur.ChoixParOrdreArrivee;
import marche.traitement.Initialisation.Initialisation;
import marche.traitement.Marche.Offre;
import marche.traitement.Producteurs.Arboriculteur;
import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestActeur {

    /**
     * assez d'argent
     */
    @Test void cotiser(){
        Acteur acteur = new Acteur(200,"Delphin");
        acteur.cotiser();
        assertTrue(acteur.aCotiser());
        assertEquals(100,acteur.getSolde());
    }

    /**
     * assez d'argent et à déjà cotisé
     */
    @Test void cotiser_DejaCotise(){
        Acteur acteur = new Acteur(300,"Delphin");
        acteur.cotiser();
        acteur.cotiser();
        assertEquals(acteur.getDateFinCotisation(),LocalDate.now().plusDays(365*2));
    }

    /**
     * Transaction , le vendeur a bien recu son argent et l'archteur a bien payer
     */
    @Test
    public void transaction_Solde(){
        Arboriculteur arboriculteur = new Arboriculteur(800,"Jean",1000);
        Produit produit = new Pomme(5,LocalDate.now(),"tonnes");
        Offre offre = new Offre(100,produit,arboriculteur, new ChoixParOrdreArrivee(), Initialisation.livreDuMarche);

        Arboriculteur arboriculteur1 = new Arboriculteur(1200,"Frank",500);

        arboriculteur1.transaction(offre);

        assert(arboriculteur1.getSolde() == 1100);
        assert(arboriculteur.getSolde() == 900);
    }


}
