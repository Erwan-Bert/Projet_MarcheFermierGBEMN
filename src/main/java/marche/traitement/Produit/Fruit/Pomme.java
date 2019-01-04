package marche.traitement.Produit.Fruit;

import java.time.LocalDate;

/**
 * 
 */
public class Pomme extends Fruit {

    @Override
    public String getNom() {
        return "pomme";
    }

    public Pomme(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption,unite);
    }

}