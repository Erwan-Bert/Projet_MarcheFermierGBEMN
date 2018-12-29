package marche.traitement.GestionnaireDeTransaction;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Marche.Offre;

public class GestionnaireDeTransaction {
    public static void transaction(Acteur acteur, Offre offre){
        System.out.println("venez nous contacter pour obtenir votre achat");
    }

    public static void transaction(VendeurAcheteur vendeurAcheteur, Offre offre){
        vendeurAcheteur.ajouterAuStock(offre.getProduit());
        System.out.println("votre produit a été mis dans votre stock(vous pouvez le renvendre), vous pouvez aussi le récupérer");
    }

}
