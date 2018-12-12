package marche.traitement.Produit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * 
 */
public class Produit {
    public int quantite;
    public String dateDePeremption;

    public Produit(int quantite, String dateDePeremption) {
        this.quantite = quantite;
        this.dateDePeremption = dateDePeremption;
    }//Produit

    public int getQuantite() {
        return quantite;
    }//getQuantite

    public String getDateDePeremption() {
        return dateDePeremption;
    }//getDateDePeremption

    public Date convertDate(String dateDeP) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(dateDeP);
        return date;
    }

    public boolean valider() throws ParseException {

        //Date du jour
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        long Ajd = System.currentTimeMillis();
        Date dateA = new Date(Ajd);

        // Test de la validite de la date de péremption
        if (convertDate(dateDePeremption).compareTo(dateA) == 1) {
            System.out.println("Le produit :" + this.getClass() + " est validé");
            return true;
        }
        else{
            System.out.println("Le produit :" + this.getClass() + " n'est pas validé");
            return false;
        }
    }//Profuit

}