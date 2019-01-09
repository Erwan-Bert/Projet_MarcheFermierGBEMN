package marche.traitement.Produit.Viande;

import java.time.LocalDate;

/**
 * 
 */
public class Vache extends Viande {


    public Vache(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

    @Override
    public String getNom() {
        return "Vache";
    }
}