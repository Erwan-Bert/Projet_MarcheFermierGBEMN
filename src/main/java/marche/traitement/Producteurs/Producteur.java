package marche.traitement.Producteurs;


import marche.traitement.Acteurs.VendeurAcheteur;

public abstract class Producteur extends VendeurAcheteur

{
    /**attributs*/

    private double limiteDeCapacite;//en kilo



    /**
     * Default constructor
     */
    public Producteur()
    {

    }

    public Producteur(double solde,String nom,double limite)
    {
        super(solde,nom);
        this.limiteDeCapacite = limite;
    }





    public double getLimite()
    {
        return limiteDeCapacite;
    }





}