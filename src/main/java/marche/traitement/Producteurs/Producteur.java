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
	
	/**
     * Initialise le Producteur avec son solde son nom et la limite (Constructeur)
	 * @param double solde
	 * @param String nom
	 * @param double limite
     */
    public Producteur(double solde,String nom,double limite)
    {
        super(solde,nom);
        this.limiteDeCapacite = limite;
    }




	/**
     * Retourne la limite du producteur
	 * @return limiteDeCapacite
     */
    public double getLimite()
    {
        return limiteDeCapacite;
    }





}