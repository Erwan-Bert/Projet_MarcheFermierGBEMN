package marche.traitement.Acteurs;

import marche.traitement.Acteurs.Cotisation.CotisationPleinPot;
import marche.traitement.Acteurs.Cotisation.StrategyCotisation;
import marche.traitement.Marche.Offre;

import java.time.LocalDate;

/**
 * Acheteur de l'application, les grossistes sont aussi des acheteurs il non pas la possibilité de revendre
 * sur ce marché (ils revendent dans des
 */
public class Acteur {
    private double solde;
    private String nom;
    private CentraleAchat membre = null;
    private StrategyCotisation cotisation = new CotisationPleinPot();
    private LocalDate dateFinCotisation;


    public Acteur() {}

    /**
     * initialise la date ou la cotisation se termine dans le passé, initilise aussi le nom et le solde
     * @param solde solde initial
     * @param nom nom de l'acteur
     */
    public Acteur(double solde, String nom) {
        this.solde = solde;
        this.nom = nom;
        this.dateFinCotisation = LocalDate.MIN;
    }


    /**
     * fait payer l'utilisateur et lui ajoute un nombre de jour sur sa période de cotisation
     * retourne si la cotisation a été un succès
	 * @return boolean retourne si l'acteur a eu assé d'argent pour cotiser
     */
    public boolean cotiser() {

        if (solde >= cotisation.calculCotisation()) {
            debiter(cotisation.calculCotisation());
            if (dateFinCotisation.isBefore(LocalDate.now()))
                dateFinCotisation = LocalDate.now();
            ajouterJoursDateFinCotisation(365);
            return true;
        }
        System.out.println("Le producteur ne dispose de pas assez d'argent");
        return false;
    }

    /**
     * permet de changer de cotisation
     * @param cotisation nouvelle cotisation
     */
    public void setCotisation(StrategyCotisation cotisation) {
        this.cotisation = cotisation;
    }
	/**
     * Permet de savoir si un utilisateur a cotisé
	 * @return boolean
     */
    public boolean aCotiser() {
        return (this.dateFinCotisation.isAfter(LocalDate.now()));
    }

	/**
	 * Initialise la date de fin de cotisation
	 * @param  dateFinCotisation  nouvelle date de fin de cotisation
     */
    protected void setDateFinCotisation(LocalDate dateFinCotisation) {
        this.dateFinCotisation = dateFinCotisation;
    }

	/**
	 * Ajoute un nombrede jour passe en paramètre a la date de fin de cotisation
	 * @param  nbjours
     */
    public void ajouterJoursDateFinCotisation(int nbjours) {
        this.dateFinCotisation = dateFinCotisation.plusDays(nbjours);
    }


    /**
	 * Permet a un utilisateur d'acheter et de l'ajouter a la liste des achetteur possibles
     * @param  o offre que l'acteur veut acheter
     */
    public void acheter(Offre o) {
        if(o.getPrix()<=solde)
        o.addAcheteurPotentiel(this);
    }

	/**
	 * Retourne la date de fin de cotisation
     * @return dateFinCotisation
     */
    public LocalDate getDateFinCotisation() {
        return dateFinCotisation;
    }
	
	/**
	 * Retourne le solde de l'Acheteur
     * @return solde
     */
    public double getSolde() {
        return solde;
    }
	
	/**
	 * Retourne le Nom de l'Acheteur
     * @return nom
     */
    public String getNom() {
        return nom;
    }
	
	/**
	 * Credite l'Acheteur d'un montant qu'on lui met en paramètre
	 * @param  montant somme à créditer
     */
    public void crediter(double montant) {
        this.solde += montant;
    }

	/**
	 * Debite l'Acheteur d'un montant qu'on lui met en parametre
	 * @param  montant somme à débiter
     */
    public void debiter(double montant) {
        this.solde -= montant;
    }

	/**
	 * Initialise la centrale d'achat a un membre passer en paramètre
	 * @param  ca
     */
    protected void setCentraleAchat(CentraleAchat ca) {
        membre = ca;
    }

	/**
	 * Retourne la centrale d'achat
     * @return membre
     */
    public CentraleAchat getCentraleAchat() {
        return membre;
    }

	/**
	 * Modifie la strategie de cotisation des utilisateurs suivant la strategie passe en paramètre
	 * @param  strategy nouvelle stratégie
     */
    public void switchStrategyCotisation(StrategyCotisation strategy)
    {
        cotisation = strategy;
    }

	/**
	 * débite l'acteur et crédite le vendeur
	 * @param  o offre sur laquel effectuer la transaction
     */
    public void transaction(Offre o){
        if (getCentraleAchat() != null)
        {
            debiter(o.getPrix() - (o.getPrix()*getCentraleAchat().getPourcentage()/100));
            System.out.println("vous béneficiez d'une ristourne car vous faites parti de la centrale d'achat "+ getCentraleAchat().getNom());

        }
        else
            debiter(o.getPrix());

         o.getVendeur().crediter(o.getPrix());
        System.out.println("Vous pouvez venir récupérer l'offre" + o + " au dépot");

    }

}