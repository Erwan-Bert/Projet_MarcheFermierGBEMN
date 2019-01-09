package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Horticulteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Epinards;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionHorticulteur extends UniteDeProduction {

    private String nom;
    public ArrayList<Horticulteur> producteurs = new ArrayList<>();
    /**
     * Default constructor
     */
    public UniteDeProductionHorticulteur(String nom) {
        super(nom);
    }

	/**
     * Ajoute un produteur a la liste des Horticulteurs
     */
    @Override
    public void ajouterMembre(Producteur producteur)throws ClassCastException {
        try
        {
            producteurs.add((Horticulteur) producteur);
        }
        catch (ClassCastException e)
        {
            System.out.println("Le producteur que vous tentez d'ajouter n'est pas du bon type");
        }
    }

	/**
     * Produit un produit issu de l'Horticulture avec a quantite le type la date de peremption et le producteur
     */
    @Override
    public void produire(Integer quantite, String type, LocalDate peremption,Producteur producteur) {
        // TODO implement here
        if (producteurs.contains(producteur))
        {
            if (producteur.getQuantiteStock() + quantite <= producteur.getLimite())
            {
                producteur.ajouterAuStock(new Epinards(quantite,peremption,"Kilogrammes"));
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

    @Override
    public ArrayList<Producteur> getMembre()
    {
        return new ArrayList<>(producteurs);
    }

}