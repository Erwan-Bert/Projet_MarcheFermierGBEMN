package marche.traitement.GestionnaireDeTransaction;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Marche.Offre;

public final class GestionnaireDeTransaction {
    public static void transaction(Acteur acteur, Offre offre){
        System.out.println("Vous pouvez venir au dépot pour obtenir votre achat à l'aide de votre pièce d'identité");

    }


    public static void transaction(VendeurAcheteur acheteur, Offre offre)
    {
        if (acheteur.getCentraleAchat() != null)
        {
            acheteur.debiter(offre.getPrix() - (offre.getPrix()*acheteur.getCentraleAchat().getPourcentage()));
            System.out.println("vous béneficiez d'une ristourne car vous faites parti d'une centrale d'achat");
        }
        else
            acheteur.debiter(offre.getPrix());

        acheteur.ajouterAuStock(offre.getProduit());
        System.out.println("votre produit a été mis dans votre stock(vous pouvez le renvendre), vous pouvez aussi le récupérer");
    }

}
