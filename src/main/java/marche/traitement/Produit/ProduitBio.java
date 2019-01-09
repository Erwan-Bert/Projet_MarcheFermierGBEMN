package marche.traitement.Produit;

public class ProduitBio extends DecorateurProduit {

    /**
     *Instancie un produit bio à partir d'un produit basique
     * @param produit est le produit basique
     */
    public ProduitBio( Produit produit) {
        super( produit);
    }


    /**
     * Permet d'ajouter Bio au nom du produit et de le renvoyer
     * @return String + bio
     */
    @Override
    public String getNom() {
        String result = produit.getNom();
        result+= " bio";
        return result;
    }
}
