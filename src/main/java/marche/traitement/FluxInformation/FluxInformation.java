package marche.traitement.FluxInformation;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Marche.Offre;

import java.util.ArrayList;
import java.util.List;

public abstract class FluxInformation {
    public String getNom() {
        return nom;
    }

    protected String nom;
    protected List<Acteur> abonnes = new ArrayList<Acteur>(); //abonnés

     public FluxInformation(String nom) {
        this.nom = nom;
    }

    public abstract void  update(Offre offre);
}
