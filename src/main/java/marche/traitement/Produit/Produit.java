package marche.traitement.Produit;

import java.time.LocalDate;

/**
 * 
 */
public abstract class Produit {
    protected int quantite;
    protected LocalDate dateDePeremption;
    protected String unite;

    public Produit(){};

    /**
     * constructeur par recopie
     * @param produit
     */
    public Produit(Produit produit){
        this.dateDePeremption = produit.dateDePeremption;
        this.quantite = produit.quantite;
        this.unite = produit.unite;

    }

    public Produit(int quantite, LocalDate dateDePeremption, String unite) {
        this.quantite = quantite;
        this.dateDePeremption = dateDePeremption;
    }//Produit

    public int getQuantite() {
        return quantite;
    }//getQuantite

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDate getDateDePeremption() {
        return dateDePeremption;
    }//getDateDePeremption

    public String getUnite() {
        return unite;
    }

    public boolean valider() {
        return (dateDePeremption.isAfter(LocalDate.now().plusDays(1)));
    }//Profuit
    public void enleverQuantite(int quantite){
        this.quantite -= quantite;
    }
    public void ajouterQuantite(int quantite){
        this.quantite += quantite;
    }


}