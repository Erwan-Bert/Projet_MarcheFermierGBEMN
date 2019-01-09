package marche.traitement.Produit.Viande;


import java.time.LocalDate;

/**
 * 
 */
public class Cochon extends Viande {

    @Override
    public String getNom() {
        return "cochon";
    }

    public Cochon(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }
}