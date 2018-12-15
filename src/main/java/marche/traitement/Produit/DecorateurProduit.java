package marche.traitement.Produit;

public abstract class DecorateurProduit extends Produit {

    protected Produit produit;

    public DecorateurProduit( Produit produit) {
        this.produit = produit;
    }

    public Produit getProduit() {
        return produit;
    }

}
