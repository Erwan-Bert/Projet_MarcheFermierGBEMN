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
     * Instancie un Marche
     * @param nom string nom que l'on attribue au marche
     * @param controleur Controleur appartenant à ce marché
     */
    public LivreDuMarche(String nom, Controleur controleur)
    {
        this.nom = nom;
        this.controleur = controleur;
    }

    /**
     * Ajoute une offre au livre du marche et notifie les flux d'info abonné à ce marcher qui vont ensuite alerter les abonnés des flux correspondant
	 * @param  o offre ajouter au livre du marché
     */
    public void ajouterOffre(Offre o)
    {
        livreMarche.add(o);
        notifierFluxInformations(o);
    }

    /**
     *  permet de cloturer une offre par son indice dans la liste des offres
     * @param numeroDeOffre int correspondant à l'indice de l'offre
     */
    public void faireChoisirUnAcheteur(int numeroDeOffre)throws IndexOutOfBoundsException{
        try
        {
            controleur.choisirAcheteur(livreMarche.get(numeroDeOffre - 1)); // indice -1 pour simplifier la compréhension
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("veuillez rentrer un indice valable");
        }
    }
	
	/**
     * Enleve une offre du livre du marche
	 * @param o offre à enlever
     */
    public void enleverOffre(Offre o)
    {
        o.getVendeur().ajouterAuStock(o.getProduit());
        o.archiver();
    }
	
	/**
     * Affice l'integralite du livre du marche
     */
    public String afficherLivre()
    {
        StringBuilder contenuLivre = new StringBuilder();
        for (Offre o:livreMarche)
        {
            contenuLivre.append(o);
        }
        return contenuLivre.toString();
    }
	
	/**
     * Retourne l'integralite du livre du marche
	 * @return LivreMarche
     */
    public List<Offre> getLivre() {
        return livreMarche;
    }

	/**
     * Ajoute une information passee en parametre au flux d'information
	 * @param  f
     */
    public void ajouterFluxInformation(FluxInformation f){
        fluxInformations.add(f);
    }

	/**
     * Enleve une information passee en parametre au flux d'information
	 * @param  f
     */
    public void enleverFluxInformation(FluxInformation f){
        fluxInformations.remove(f);
    }

	/**
     * Notifie lorsque le flux d'information est mis a jour
	 * @param  offre
     */
    public void notifierFluxInformations(Offre offre){
        for(FluxInformation f : fluxInformations){
            f.update(offre);
        }
    }

    @Override
    public String toString() {
        return "LivreDuMarche{" +
                "nom='" + nom + "\'\n" +
                ", " + nom + " contient\n" + afficherLivre() +
                ", fluxInformations=" + fluxInformations +
                ", controleur=" + controleur.getNom() +
                '}';
    }
}
