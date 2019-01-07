package marche.traitement.Produit;

public class ProduitBio extends DecorateurProduit {
    private boolean certification = false; // Certification du produit , valeur de base nulle

    /**
     * Constructeur lorsque qu'on veut initialiser la certification aussi
     * @param produit
     * @param certification
     */
    public ProduitBio( Produit produit, boolean certification ) {
        super( produit);
        this.certification = certification;
    }


    /**
     *
     * @param produit
     */
    public ProduitBio( Produit produit) {
        super( produit);
    }

    /**
     *
     * @return boolean
     */
    public boolean isCertifie() {
        return certification;
    }

    public void certifier(){
        certification = true;
    }

    public void decertifier(){
        certification = false;
    }

    @Override
    public String getNom() {
        String result = produit.getNom();
        if(isCertifie())
            result+= " bio";

        return result;
    }
}
