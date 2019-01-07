package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.Produit.ProduitsLaitiers.Fromage;
import marche.traitement.Produit.ProduitsLaitiers.Lait;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionLaitier extends UniteDeProduction
{


    public ArrayList<ProducteurLaitier> producteurs = new ArrayList<>();
    private String nom;

    public UniteDeProductionLaitier(String nom)
    {
        super(nom);
    }

	/**
     * Ajoute un producteur a la liste des producteurs laitiers
     */
    @Override
    protected void ajouterMembre(Producteur producteur)throws ClassCastException {
            producteurs.add((ProducteurLaitier) producteur);
    }

	/**
     * Produit un produit issu du lait avec la quantite le type la date de peremption et le producteur
     */
    @Override
    public void produire(int quantite, String type, LocalDate peremption,Producteur producteur)
    {
        if (producteurs.contains(producteur))
        {
            if (producteur.getQuantiteStock() + quantite <= producteur.getLimite())
            {
                if (type.equals("lait"))
                producteur.ajouterAuStock(new Lait(quantite,peremption,"Kilogrammes"));
                else
                producteur.ajouterAuStock(new Fromage(quantite,peremption,"Kilogrammes"));

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