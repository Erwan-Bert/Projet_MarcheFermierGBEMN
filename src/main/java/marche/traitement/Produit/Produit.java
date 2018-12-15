package marche.traitement.Produit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

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

    public LocalDate getDateDePeremption() {
        return dateDePeremption;
    }//getDateDePeremption


    public boolean valider() {
        return (dateDePeremption.isAfter(LocalDate.now().plusDays(1)));
    }//Profuit

}