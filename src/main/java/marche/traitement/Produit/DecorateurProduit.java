package marche.traitement.Produit;

public class DecorateurProduit extends Produit {

    protected Produit produit;

    public DecorateurProduit(int quantite, String dateDePeremption, Produit produit) {
        super(quantite, dateDePeremption);
        this.produit = produit;
    }

    public Produit getProduit() {
        return produit;
    }

    public int getQuantite(){
        return this.quantite;
    }

    public String getDateDePeremption(){
        return this.dateDePeremption;
    }
}
