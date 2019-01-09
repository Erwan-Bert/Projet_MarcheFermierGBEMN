package marche.traitement.Producteurs;


import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Produit.Produit;

import java.time.LocalDate;

public abstract class Producteur extends VendeurAcheteur

{
    /**attributs*/

    private double limiteDeCapacite;//en kilo



    /**
     * Default constructor
     */
    public Producteur() {}

    /**
     * permet d'instancier un Producteur
     * @param solde double correspond au solde de base de l'agriculteur
     * @param nom string correspond au nom de l'agriculteur
     * @param limite double correspond à la limite de stockage de l'agriculteur
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

    /**
     * récupère un produit dans le stock à partir d'une decription
     * récupère la quantite demandé si possible et le maximum sinon
     * @param quantite
     * @param type
     * @param peremption
     * @return
     */
    public Produit getProduitDansStock(int quantite, String type, LocalDate peremption){
        for(Produit produit : stocks){
            if(produit.getNom().equals(type) && produit.getDateDePeremption().equals(peremption)){
                if(produit.getQuantite() <= quantite){
                    return produit;
                }else if(produit.getQuantite() > quantite)
                {
                    Produit produitaEnlever = produit.clone();
                    produitaEnlever.enleverQuantite(produit.getQuantite()-quantite);
                    produit.enleverQuantite(quantite);
                    return produitaEnlever;
                }

            }
        }
        System.out.println("Le produit demandé n'est pas présent");
        return null;
    }

    @Override
    public String toString()
    {
        if (getQuantiteStock() == 0)
            return getNom() + "{" +
                    "limiteDeCapacite=" + limiteDeCapacite + "kg" +
                    ", stocks=" + afficherStock() +
                    "}\n";
        return getNom() + "{" +
                "limiteDeCapacite=" + limiteDeCapacite + "kg" +
                ", stocks=" + getQuantiteStock() + "kg" + afficherStock() +
                "}\n";
    }
}