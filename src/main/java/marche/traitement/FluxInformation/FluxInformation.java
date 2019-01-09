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
	 * @param String nom
     */
    public FluxInformation(String nom)
    {
        this.nom = nom;
        Initialisation.listeNewsLetter.add(this);
    }

	/**
     *  Met a jour une offre
	 * @param Offre offre
     */
    public abstract void  update(Offre offre);

	/**
     * Ajoute un abonne a la liste des abonnes
	 * @param Acteur a
     */
    public void ajouterAbonne(Acteur a){
        abonnes.add(a);
    }
	
	/**
     * Enleve un abonne a la liste des abonnes
	 * @param Acteur a
     */
    public void enleverAbonne(Acteur a){
        abonnes.remove(a);
    }

}
