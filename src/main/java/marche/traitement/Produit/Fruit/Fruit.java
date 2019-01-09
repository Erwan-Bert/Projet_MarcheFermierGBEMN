package marche.traitement.Produit.Fruit;

import marche.traitement.Produit.Produit;

import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
public abstract class Fruit extends Produit {


    public Fruit() {
    }

    public Fruit(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }
}