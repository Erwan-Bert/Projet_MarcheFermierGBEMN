package marche.traitement.UnitedeProduction;


import marche.traitement.Producteurs.Arboriculteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Fruit.Pomme;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionArboriculteur extends UniteDeProduction {

    private String nom;
    public ArrayList<Arboriculteur> producteurs = new ArrayList<>();
    /**
     * Default constructor
     */
    public UniteDeProductionArboriculteur(String nom) {
        super(nom);
    }

	/**
     * Ajoute un producteur a la liste des Arboriculteurs
     */
    @Override
    public void ajouterMembre(Producteur producteur)throws ClassCastException {
        try
        {
            producteurs.add((Arboriculteur) producteur);
        }
        catch (ClassCastException e)
        {
            System.out.println("Le producteur que vous tentez d'ajouter n'est pas du bon type");
        }
    }

	/**
     * Produit un produit issu de l'arboriculture avec la quantite le type la date de peremption et le producteur
     */
    @Override
    public void produire(int quantite, String type, LocalDate peremption,Producteur producteur)
    {
        if (producteurs.contains(producteur))
        {
            if (producteur.getQuantiteStock() + quantite <= producteur.getLimite())
            {
                producteur.ajouterAuStock(new Pomme(quantite,peremption,"Kilogrammes"));
            }
            else
            {
                System.out.println("tu peux pas produire autant ta limite de stock est "+ producteur.getLimite());
            }

        }
        else
        {
            System.out.println("Vous n'appartenez pas à une unité de production");
        }

    }

}