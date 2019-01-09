package marche.traitement.UnitedeProduction.UnitedeProdLabel;

import marche.traitement.Producteurs.DecorateurProducteur.DecorateurProducteur;
import marche.traitement.Producteurs.Producteur;
import marche.traitement.UnitedeProduction.UniteDeProduction;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class  UniteDeProductionLabelise extends UniteDeProduction
{
    protected ArrayList<DecorateurProducteur> porducteursLabelises = new ArrayList<>();
    protected UniteDeProduction up;

    /**
     * Construire une unité de production labélisée
     * @param up est une unité de production basique
     */
    public UniteDeProductionLabelise(UniteDeProduction up) {
        super();
        this.up = up;

    }

    /**
     *
     * @param  quantite  correspond à la quantité à produire
     * @param type correspond au type d'aliment à produire
     * @param peremption désine la date de peremption du produit
     * @param producteur est le producteur qui produit à travers l'unité de production
     */
    @Override
    public abstract void produire(Integer quantite, String type, LocalDate peremption, Producteur producteur);
}
