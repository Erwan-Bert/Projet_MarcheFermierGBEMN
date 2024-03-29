package marche.traitement.Produit;

import java.time.LocalDate;

/**
 * 
 */
public abstract class Produit implements  Cloneable{
    protected int quantite;
    protected LocalDate dateDePeremption;
    protected String unite;



    protected Produit(){}

    /**
     *
     * @return une copie d'un Produit mais pas par référence
     */
    public Produit clone() {
        Produit produit = null;
        try
        {
            produit = (Produit) super.clone();
        }catch(CloneNotSupportedException c){
            System.out.println("erreur dans la segmentation du produit");
        }

        return produit;
    }
	/**
     * Constructeur
     */
    public Produit(int quantite, LocalDate dateDePeremption, String unite) {
        this.quantite = quantite;
        this.dateDePeremption = dateDePeremption;
        this.unite = unite;
    }

	/**
     * Renvoi la quantité d'un produit
     * @return int
     */
    public int getQuantite() {
        return quantite;
    }
	
	/**
     * Initialise la quantité d'un produit
     * @param  quantite int
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

	/**
     * Renvoi la date d'un peremption d'un produit
     * @return boolean
     */
    public LocalDate getDateDePeremption() {
        return dateDePeremption;
    }

	/**
     * Renvoi l'unité d'un produit
     * @return boolean
     */
    public String getUnite() {
        return unite;
    }
    /**
     * Renvoi si un produit est validé , en fonction de sa date de peremption
     * @return boolean
     */
    public boolean valider() {
        return (dateDePeremption.isAfter(LocalDate.now().plusDays(1)));
    }
	
	/**
     * Enleve une quantité passée en paramètre a un produit
     * @param  quantite int
     */
    public void enleverQuantite(int quantite){
        this.quantite -= quantite;
    }
	
	/**
     * Ajoute une quantité passée en paramètre a un produit
     * @param  quantite int
     */
    public void ajouterQuantite(int quantite){
        this.quantite += quantite;
    }
    public abstract String getNom();


}