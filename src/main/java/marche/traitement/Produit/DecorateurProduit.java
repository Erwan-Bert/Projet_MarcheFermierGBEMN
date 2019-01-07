package marche.traitement.Produit;

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

}
