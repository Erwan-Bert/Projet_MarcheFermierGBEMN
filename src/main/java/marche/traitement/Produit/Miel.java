package marche.traitement.Produit;

import java.time.LocalDate;

/**
 * 
 */
public class Miel extends Produit {

    @Override
    public String getNom() {
        return "miel";
    }

    public Miel(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }


}