package marche.traitement.Produit;

import java.time.LocalDate;

public abstract class DecorateurProduit extends Produit {

    protected Produit produit;

	/**
     * Constructeur du DecorateurProduit
     */
    public DecorateurProduit( Produit produit) {
        this.produit = produit;
    }

	/**
     * Retourne le produit spécifique
	 * @return produit
     */
    public Produit getProduit() {
        return produit;
    }

    @Override
    public int getQuantite() {
        return produit.getQuantite();
    }

    @Override
    public void setQuantite(int quantite) {
        produit.setQuantite(quantite);
    }

    @Override
    public LocalDate getDateDePeremption() {
       return produit.getDateDePeremption();
    }

    @Override
    public String getUnite() {
        return produit.getUnite();
    }

    /**
     * permet d'enlever une certaine quantite au produit correspondant
     * @param  quantite int
     */
    @Override
    public void enleverQuantite(int quantite) {
        produit.enleverQuantite(quantite);
    }

    /**
     * permet d'ajouter une quantité au produit correspondant
     * @param  quantite int
     */
    @Override
    public void ajouterQuantite(int quantite) {
        produit.ajouterQuantite(quantite);
    }

    @Override
    public String getNom() {
        return produit.getNom() +" bio";
    }
}
