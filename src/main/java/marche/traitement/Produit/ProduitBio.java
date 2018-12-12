package marche.traitement.Produit;

public class ProduitBio extends DecorateurProduit {
    private boolean certification = false; // Certification du produit , valeur de base nulle

    public ProduitBio(int quantite, String dateDePeremption, Produit produit, boolean certificaion) {
        super(quantite, dateDePeremption, produit);
        this.certification = certificaion;
    }

    public boolean isCertificaion() {
        return certification;
    }

    public void certifier(){
        System.out.println(this.getProduit() + "est bio");
        certification = true;
    }

    public void decertifier(){
        System.out.println(this.getProduit() + "n'est pas bio");
        certification = false;
    }
}
