package marche.traitement.Produit.ProduitsLaitiers;


import java.util.Date;

/**
 * 
 */
public class Fromage extends ProduitsLaitier {

    public String unite;

    public Fromage(int quantite, Date dateDePeremption, String unite) {
        super(quantite, dateDePeremption);
        this.unite = unite;
    }

    public String getUnite() {
        return unite;
    }
}