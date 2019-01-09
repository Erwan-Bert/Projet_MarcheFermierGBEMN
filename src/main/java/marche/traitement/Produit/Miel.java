package marche.traitement.Produit;

import java.time.LocalDate;

/**
 * 
 */
public class Miel extends Produit {

    /**
     * renvoie le nom du produit fonction heritée de Produit
     * @return  nom du produit
     */
    @Override
    public String getNom() {
        return "miel";
    }

    /**
     * Instancie un objet miel , hétite du constructeur Produit
     * @param quantite correspond à la quantité que l'on veut produire
     * @param dateDePeremption correspond à la date de peremption des produits
     * @param unite correspond au type d'unité (litre, kilo ...)
     */
    public Miel(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

}