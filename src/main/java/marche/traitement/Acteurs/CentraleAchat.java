package marche.traitement.Acteurs;

import java.util.ArrayList;
import java.util.Collection;

public class CentraleAchat extends Acteur
{
    private int pourcentage;

    @Override
    public String getNom() {
        return nom;
    }

    private String nom;
    private Collection<Acteur> membres;

	/**
	 * Initialise une centrale d'achat (Constructeur)
	 * @param String nom
     */
    public CentraleAchat (String nom)
    {
        this.nom = nom;
        membres = new ArrayList<>();
    }

	/**
	 * Initialise le pourcentage passe en paramètre
	 * @param int pourcentage
     */
    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

	/**
	 * Retourne le pourcentage de la Centrale d'achat
	 * @return pourcentage
     */
    public int getPourcentage() {
        return pourcentage;
    }

	/**
	 * Ajoute un membre passer en paramètre a la centrale d'achat
	 * @param Acteur membre
     */
    public void ajouterMembres(Acteur membre)
    {
        membres.add(membre);
        membre.setCentraleAchat(this);
    }

	/**
	 * Enleve un membre passer en paramètre a la centrale d'achat
	 * @param Acteur membre
     */
    public void enleverMembre(Acteur membre)
    {
        membres.remove(membre);
        membre.setCentraleAchat(null);
    }

}
