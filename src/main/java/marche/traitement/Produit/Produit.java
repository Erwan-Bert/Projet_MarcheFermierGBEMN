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


    public Produit(int quantite, LocalDate dateDePeremption, String unite) {
        this.quantite = quantite;
        this.dateDePeremption = dateDePeremption;
        this.unite = unite;
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

    /**
     *
     * @return boolean
     */
    public boolean valider() {
        return (dateDePeremption.isAfter(LocalDate.now().plusDays(1)));
    }
    public void enleverQuantite(int quantite){
        this.quantite -= quantite;
    }
    public void ajouterQuantite(int quantite){
        this.quantite += quantite;
    }


}