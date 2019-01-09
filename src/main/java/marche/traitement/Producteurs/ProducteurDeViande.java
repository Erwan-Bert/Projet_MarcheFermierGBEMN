package marche.traitement.Producteurs;

/**
 * 
 */
public class ProducteurDeViande extends Producteur {

    /**
     * permet d'instancier un Producteur de viande
     * @param solde double correspond au solde de base de l'agriculteur
     * @param nom string correspond au nom de l'agriculteur
     * @param limite double correspond à la limite de stockage de l'agriculteur
     */
    public ProducteurDeViande(double solde,String nom,double limite) {
        super(solde,nom, limite);
    }


}