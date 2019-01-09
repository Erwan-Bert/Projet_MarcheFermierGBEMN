package marche.traitement.Produit.ProduitsLaitiers;


import java.time.LocalDate;

/**
 * 
 */
public class Fromage extends ProduitsLaitier {

    /**
     * permet d'obtenir le nom
     * @return string
     */
    @Override
    public String getNom() {
        return "fromage";
    }

    /**
     * Instancie un objet miel , hétite du constructeur Produit
     * @param quantite correspond à la quantité que l'on veut produire
     * @param dateDePeremption correspond à la date de peremption des produits
     * @param unite correspond au type d'unité (litre, kilo ...)
     */
    public Fromage(int quantite, LocalDate dateDePeremption, String unite) {
        super(quantite, dateDePeremption, unite);
    }

}