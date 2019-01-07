package marche.traitement.Produit.ProduitsLaitiers;


import java.time.LocalDate;

/**
 * 
 */
public class Fromage extends ProduitsLaitier {
    @Override
    public String getNom() {
        return "fromage";
    }

    public Fromage(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

}