package marche.traitement.Marche;

import marche.traitement.Acteurs.controleur.Controleur;
import marche.traitement.FluxInformation.FluxInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class LivreDuMarche {


    private List<Offre> livreMarche = new ArrayList<Offre>();
    private List<FluxInformation> fluxInformations = new ArrayList<FluxInformation>();

    public Controleur getControleur() {
        return controleur;
    }

    public String getNom() {
        return nom;
    }

    private Controleur controleur;
    private String nom ;

    /**
     * Default constructor
     */
    public LivreDuMarche(String nom, Controleur controleur)
    {
        this.nom = nom;
        this.controleur = controleur;
    }

    /**
     * Ajoute une offre au livre du marche
	 * @param Offre o
     */
    public void ajouterOffre(Offre o)
    {
        livreMarche.add(o);
        notifierFluxInformations(o);

    }
	
	/**
     * Choisit un acheter qui pourra acheter l'offre , avec le numero de l'offre en param�tre
	 * @return int numeroDeOffre
     */
    public void faireChoisirUnAcheteur(int numeroDeOffre){
        try {
            controleur.choisirAcheteur(livreMarche.get(numeroDeOffre - 1)); // indice -1 pour simplifier la compréhension
        }catch (IndexOutOfBoundsException e){
            System.out.println("veuillez rentrer un indice valable");
        }
    }
	
	/**
     * Enleve une offre du livre du marche
	 * @param
     */
    public void enleverOffre(Offre o){
        livreMarche.remove(o);
        o.getVendeur().ajouterAuStock(o.getProduit());
        o.archiver();

    }
	
	/**
     * Affice l'int�gralit� du livre du marche
     */
    public void afficherLivre()
    {
        for (Offre o:livreMarche)
        {
            System.out.println(o);

        }
    }
	
	/**
     * Retourne l'int�gralit� du livre du marche
	 * @return LivreMarche
     */
    public List<Offre> getLivre() {
        return livreMarche;
    }

	/**
     * Ajoute une information pass�e en param�tre au flux d'information
	 * @param FluxInformation f
     */
    public void ajouterFluxInformation(FluxInformation f){
        fluxInformations.add(f);
    }

	/**
     * Enleve une information pass�e en param�tre au flux d'information
	 * @param FluxInformation f
     */
    public void enleverFluxInformation(FluxInformation f){
        fluxInformations.remove(f);
    }

	/**
     * Notifie lorsque le flux d'information est mis a jour
	 * @param Offre offre
     */
    public void notifierFluxInformations(Offre offre){
        for(FluxInformation f : fluxInformations){
            f.update(offre);
        }
    }


}
