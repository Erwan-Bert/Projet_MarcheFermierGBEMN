package Tests.Acteurs;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Epinards;
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
     * assez d'argent
     */
    @Test void acheter(){
        VendeurAcheteur acteur = new VendeurAcheteur(300,"Delphin");
        acteur.cotiser();
        Produit produit = new Epinards(10,LocalDate.now(),"");
        Offre offre = new Offre(100,produit, acteur);

        acteur.acheter(offre);
    }

}
