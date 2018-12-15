package marche.traitement.Produit.Fruit;

import marche.traitement.Produit.Produit;

import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
public class Pomme extends Fruit {


    public Pomme(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption,unite);
    }

}