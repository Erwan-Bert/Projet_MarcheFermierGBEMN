package marche.traitement.Produit;

import java.time.LocalDate;

/**
 * 
 */
public class Epinards extends Produit {
    @Override
    public String getNom() {
        return "épinards";
    }

    public Epinards(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

}