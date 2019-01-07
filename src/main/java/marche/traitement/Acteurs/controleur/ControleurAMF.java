package marche.traitement.Acteurs.controleur;

import marche.traitement.Marche.Offre;

import java.util.ArrayList;
import java.util.List;

public class ControleurAMF extends Controleur{
    private List<String> blaclistProduit ;

    public ControleurAMF( ArrayList<String>blacklistProduit) {
        super();
        this.blaclistProduit = blacklistProduit;
    }

    public void ajouterALABlacklist(String nom){
        blaclistProduit.add(nom);
    }
    public void retirerALABlacklist(String nom){
        blaclistProduit.remove(nom);
    }
    public String afficherBlacklist(){
        StringBuilder s = new StringBuilder();
        for(String produit : blaclistProduit){
            s.append(produit);
        }
        return s.toString();
    }

    /**
     * effectue des vérification sur l'offre pour vérifier si celle ci peut entrer dans le marché
     * toutes les conditions ne sont pas directement misent dans le return pour aider la lisibilité
     * @param o
     * @return boolean
     */
    @Override
    public boolean validerOffre(Offre o) {
        if(blaclistProduit.contains(o.getProduit().getNom()))
            return false;

        return ( 0<o.getPrix()  && o.getPrix() < 1000000);
    }

    @Override
    public String getNom(){
        return "AMF";
    }
}
