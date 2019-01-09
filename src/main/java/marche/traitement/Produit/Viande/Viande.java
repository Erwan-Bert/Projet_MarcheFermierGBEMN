package marche.traitement.Produit.Viande;


import marche.traitement.Produit.Produit;

import java.time.LocalDate;

/**
 * 
 */
public abstract class Viande extends Produit {

    /**
     * Instancie un objet miel , hétite du constructeur Produit
     * @param quantite correspond à la quantité que l'on veut produire
     * @param dateDePeremption correspond à la date de peremption des produits
     * @param unite correspond au type d'unité (litre, kilo ...)
     */
    public Viande(int quantite, LocalDate dateDePeremption,String unite) {
        super(quantite, dateDePeremption,unite);
    }
}