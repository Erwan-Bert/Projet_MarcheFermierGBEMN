package marche.traitement.Produit;

import java.util.*;
import java.util.Date;

/**
 * 
 */
public class Produit {
    public int quantite;
    public Date dateDePeremption;

    public Produit(int quantite, Date dateDePeremption) {
        this.quantite = quantite;
        this.dateDePeremption = dateDePeremption;
    }//Produit

    public int getQuantite() {
        return quantite;
    }//getQuantite

    public Date getDateDePeremption() {
        return dateDePeremption;
    }//getDateDePeremption

    public boolean valider() {

        //Date du jour
        long Ajd = System.currentTimeMillis();
        Date dateA = new Date(Ajd);

        // Test de la validite de la date de péremption
        if (dateDePeremption.compareTo(dateA) == -1)
            return true;
        else
            return false;
    }//Profuit

}