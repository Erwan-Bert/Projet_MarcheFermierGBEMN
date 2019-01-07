package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Apiculteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Miel;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionApiculteur extends UniteDeProduction {

    private String nom;
    public ArrayList<Apiculteur> producteurs = new ArrayList<>();
    /**
     * Default constructor
     */
    public UniteDeProductionApiculteur(String nom) {

        super(nom);
    }
	
	/**
     * Ajoute un membre a la liste des Apiculteurs
     */
    @Override
    protected void ajouterMembre(Producteur producteur)throws IllegalStateException {
        try
        {
            producteurs.add((Apiculteur) producteur);
        }
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        }
    }
	
	/**
     * Produit le produit en question avec la quantite le type la date de peremption et le producteur
     */
    @Override
    public void produire(int quantite, String type, LocalDate peremption,Producteur producteur) {

        if (producteurs.contains(producteur))
        {
            if (producteur.getQuantiteStock() + quantite <= producteur.getLimite())
            {
                producteur.ajouterAuStock(new Miel(quantite,peremption,"Kilogrammes"));
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