package marche.traitement.Producteurs;


import marche.traitement.Acteurs.VendeurAcheteur;

public class Producteur extends VendeurAcheteur

{
    /**attributs*/

    private int limiteDeCapacite;


    /**
     * Default constructor
     */
    public Producteur(double solde,int limite)
    {
        super(solde);
        this.limiteDeCapacite = limite;
    }





    public void getLimite()
    {
        System.out.println("La limite de ce producteur est de "+ this.limiteDeCapacite);
    }





    public void cotiser() {
        // TODO implement here
    }

}