package marche.traitement;

import marche.traitement.Produit.Produit;
import marche.traitement.Produit.ProduitsLaitiers.Lait;
import marche.traitement.Produit.ProduitsLaitiers.ProduitsLaitier;
import marche.traitement.Produit.Viande.Cochon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMarche {
    public static void main(String[] args) throws ParseException {
        Produit produit1 = new Lait(5,"13/12/2018","Litres");
        Produit produit2 = new Cochon(10,"11/12/2018","Kilogrames");
        produit1.valider();
        produit2.valider();
    }
}
