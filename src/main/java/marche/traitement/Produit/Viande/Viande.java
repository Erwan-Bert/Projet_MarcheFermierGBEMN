package marche.traitement.Produit.Viande;


import marche.traitement.Produit.Produit;

import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */
public abstract class Viande extends Produit {

    public Viande(int quantite, LocalDate dateDePeremption,String unite) {
        super(quantite, dateDePeremption,unite);
    }
}