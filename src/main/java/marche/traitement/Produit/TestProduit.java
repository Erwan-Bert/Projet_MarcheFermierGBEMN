package marche.traitement.Produit;

import marche.traitement.Produit.ProduitsLaitiers.Lait;
import marche.traitement.Produit.ProduitsLaitiers.ProduitsLaitier;

import java.util.Date;

public class TestProduit {
    public static void main(String[] args) {
        Produit produit1 = new Lait(5,new Date(2020,4,11),"Litre");
        produit1.valider();
    }
}
