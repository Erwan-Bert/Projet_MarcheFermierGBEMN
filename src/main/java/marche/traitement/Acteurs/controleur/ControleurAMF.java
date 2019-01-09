package marche.traitement.Acteurs.controleur;

import marche.traitement.Marche.Offre;

import java.util.ArrayList;

public class ControleurAMF extends Controleur{


    public ControleurAMF( ArrayList<String> blacklistProduit) {
        super(blacklistProduit);
    }

    /**
     * effectue des vérification sur l'offre pour vérifier si celle ci peut entrer dans le marché
     *
     * @param o offre
     * @return boolean
     */
    @Override
    public boolean validerOffre(Offre o) {
        //toutes les conditions ne sont pas directement misent dans les
        //parenthèses du return  pour aider la lisibilité
        if(blaclistProduit.contains(o.getProduit().getNom()))
            return false;

        return ( 0<o.getPrix()  && o.getPrix() < 1000000);
    }

    @Override
    public String getNom(){
        return "AMF";
    }
}
