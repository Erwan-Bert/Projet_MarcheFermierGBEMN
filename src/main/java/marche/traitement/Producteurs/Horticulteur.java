package marche.traitement.Producteurs;

/**
 * 
 */
public class Horticulteur extends Producteur {

    /**
     * permet d'instancier un Horticulteur
     * @param solde double correspond au solde de base de l'agriculteur
     * @param nom string correspond au nom de l'agriculteur
     * @param limite double correspond à la limite de stockage de l'agriculteur
     */
    public Horticulteur(double solde,String nom,double limite) {
        super(solde,nom,limite);
    }

}