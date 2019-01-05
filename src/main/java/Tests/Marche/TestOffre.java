package Tests.Marche;

import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Fruit.Pomme;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestOffre {
    @Test public void offre(){
        Pomme pomme = new Pomme(4, LocalDate.now(),"Tonne");
        VendeurAcheteur vendeurAcheteur = new VendeurAcheteur(1000,"Sylvie");
        Offre offre = new Offre(100,pomme,vendeurAcheteur);



    }
}
