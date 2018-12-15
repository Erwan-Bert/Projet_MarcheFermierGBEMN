package marche.traitement.Producteurs;


import marche.traitement.Acteurs.VendeurAcheteur;

public abstract class Producteur extends VendeurAcheteur

{
    /**attributs*/

    private int limiteDeCapacite;



    /**
     * Default constructor
     */
    public Producteur()
    {

    }

    public Producteur(double solde,String nom,int limite)
    {
        super(solde,nom);
        this.limiteDeCapacite = limite;
    }





    public void getLimite()
    {
        System.out.println("La limite de ce producteur est de "+ this.limiteDeCapacite);
    }





}