package marche.traitement.Produit.Fruit;

import java.time.LocalDate;

/**
 * 
 */
public class Pomme extends Fruit {

    /**
     * permet d'obtenir le nom du produit
     * @return string
     */
    @Override
    public String getNom() {
        return "pomme";
    }

    /**
     * Instancie un objet miel , hétite du constructeur Produit
     * @param quantite correspond à la quantité que l'on veut produire
     * @param dateDePeremption correspond à la date de peremption des produits
     * @param unite correspond au type d'unité (litre, kilo ...)
     */
    public Pomme(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption,unite);
    }

}