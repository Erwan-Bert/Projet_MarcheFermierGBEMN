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

    public UniteDeProductionLabelise(UniteDeProduction up) {
        super();
        this.up = up;

    }
    @Override
    public void produire(Integer quantite, String type, LocalDate peremption, Producteur producteur){
        //produireProduitLabelise(quantite,type,peremption,(DecorateurProducteur) producteur);
    }
    //public abstract void produireProduitLabelise(int quantite, String type, LocalDate peremption, DecorateurProducteur producteur);
}
