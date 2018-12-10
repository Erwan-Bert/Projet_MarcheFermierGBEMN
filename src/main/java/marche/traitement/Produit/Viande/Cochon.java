package marche.traitement.Produit.Viande;


import java.util.Date;

/**
 * 
 */
public class Cochon extends Viande {

    public String unite;


    public Cochon(int quantite, Date dateDePeremption, String unite) {
        super(quantite, dateDePeremption);
        this.unite = unite;
    }

    public String getUnite() {
        return unite;
    }
}