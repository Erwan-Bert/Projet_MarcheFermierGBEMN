package marche.traitement.FluxInformation;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Initialisation.Initialisation;
import marche.traitement.Marche.Offre;

import java.util.ArrayList;
import java.util.List;

public abstract class FluxInformation {
    public String getNom() {
        return nom;
    }

    protected String nom;
    protected List<Acteur> abonnes = new ArrayList<Acteur>(); //abonnés
	
	/**
     *  Initialise un flux d'information (Constructeur)
	 * @param nom nom du flux
     */
    public FluxInformation(String nom)
    {
        this.nom = nom;
        Initialisation.listeNewsLetter.add(this);
    }

	/**
     *  Met a jour une offre
	 * @param offre l'offre mise à jour
     */
    public abstract void  update(Offre offre);

	/**
     * Ajoute un abonne a la liste des abonnes
	 * @param acteur acteur correspondant à l'abonné
     */
    public void ajouterAbonne(Acteur acteur){
        abonnes.add(acteur);
    }
	
	/**
     * Enleve un abonne a la liste des abonnes
	 * @param acteur retire cet acteur de la liste
     */
    public void enleverAbonne(Acteur acteur){
        abonnes.remove(acteur);
    }

}
