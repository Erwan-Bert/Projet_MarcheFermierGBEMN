package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Producteurs.ProducteurDeViande;
import marche.traitement.Produit.Viande.Cochon;
import marche.traitement.Produit.Viande.vache;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 */
public class UniteDeProductionProducteurDeViande extends UniteDeProduction {


    public ArrayList<ProducteurDeViande> producteurs = new ArrayList<>();
    private String nom;

    /**
     * Default constructor
     */
    public UniteDeProductionProducteurDeViande(String nom) {

        super(nom);
    }

    @Override
    protected void ajouterMembre(Producteur producteur) throws ClassCastException {
        try {
            producteurs.add((ProducteurDeViande) producteur);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void produire(int quantite, String type, LocalDate peremption, Producteur producteur) {
        if (producteurs.contains(producteur)) {
            if (producteur.getQuantiteStock() + quantite <= producteur.getLimite()) {
                if (type.equals("cochon"))
                    producteur.ajouterAuStock(new Cochon(quantite, peremption, "Kilogrammes"));
                else
                    producteur.ajouterAuStock(new vache(quantite, peremption, "Kilogrammes"));

            } else {
                System.out.println("tu peux pas produire autant ta limite de stock est " + producteur.getLimite());
            }
        } else {
            System.out.println("Vous n'appartenez pas à une unité de production");
        }


    }
}