package marche.traitement.UnitedeProduction;

import marche.traitement.Producteurs.Producteur;
import marche.traitement.Produit.Fruit.Fruit;
import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;
import marche.traitement.Produit.ProduitsLaitiers.Lait;
import marche.traitement.Produit.ProduitsLaitiers.ProduitsLaitier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 */
public abstract class UniteDeProduction {


    protected List<Producteur> groupeDeProd;
    /**
     * Default constructor
     */
    public UniteDeProduction()
    {

    }

    public static Produit fabriquer(String type, Integer quantite, LocalDate peremption)
    {
        try
        {
            return creer(type, quantite, peremption);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("objet inexistant");
        }
        return null;
    }

    private static Produit creer (String type, Integer quantite, LocalDate peremption) throws ClassNotFoundException
    {
        UniteDeProductionLaitier uniteDeProductionLaitier = new UniteDeProductionLaitier();
        UniteDeProductionArboriculteur uniteDeProductionArboriculteur = new UniteDeProductionArboriculteur();
        UniteDeProductionProducteurDeViande uniteDeProductionProducteurDeViande = new UniteDeProductionProducteurDeViande();
        UniteDeProductionApiculteur uniteDeProductionApiculteur = new UniteDeProductionApiculteur();
        UniteDeProductionHorticulteur uniteDeProductionHorticulteur = new UniteDeProductionHorticulteur();

        switch (type)
        {
            case "pomme":
                return  uniteDeProductionArboriculteur.produire(quantite, type, peremption);
            case "lait":
                return uniteDeProductionLaitier.produire(quantite, type, peremption);
            case "fromage":
                return uniteDeProductionLaitier.produire(quantite, type, peremption);
            case "cochon":
                return uniteDeProductionProducteurDeViande.produire(quantite, type, peremption);
            case "vache":
                return uniteDeProductionProducteurDeViande.produire(quantite, type, peremption);
            case "miel":
                return uniteDeProductionApiculteur.produire(quantite, type, peremption);
            case "epinard":
                return uniteDeProductionHorticulteur.produire(quantite, type, peremption);
            default: throw new ClassNotFoundException();
        }
    }

    public abstract Produit produire(int quantite, String type, LocalDate peremption);



}