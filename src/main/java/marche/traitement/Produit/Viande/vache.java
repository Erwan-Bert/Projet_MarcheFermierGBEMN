package marche.traitement.Produit.Viande;

import java.time.LocalDate;

/**
 * 
 */
public class vache extends Viande {


    public vache(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

    @Override
    public String getNom() {
        return "vache";
    }
}