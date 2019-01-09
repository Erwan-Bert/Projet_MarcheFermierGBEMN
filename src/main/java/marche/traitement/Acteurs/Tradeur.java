package marche.traitement.Acteurs;

import marche.traitement.Acteurs.ChoixAcheteur.StrategyChoixAcheteur;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

import java.util.Calendar;


public class Tradeur extends VendeurAcheteur
{

    private static int heureMin = 8;
    private static int heureMax = 18;
    private static Calendar cal = Calendar.getInstance();


    public Tradeur(String nom, double solde)
    {
        super(solde,nom);
    }

    /**
     * méthode qui vérifie si l'heure actuelle est comprise entre les deux heures déclarée plus haut renvoie faux dans le cas contraire
     * @return true si l'heure du moment est comprise entre heureMin et heureMax
     */
    private boolean verifHeure()
    {
        if (cal.get(Calendar.HOUR_OF_DAY) >= heureMin && cal.get(Calendar.HOUR_OF_DAY) <= heureMax)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * permet à un tradeur d'acheter sur le marché (utilise la méthode acheter dans acteur) avec vérification des heures de travail
     * @param  o offre que le tradeur veut acheter
     */
    @Override
    public void acheter(Offre o)
    {
        if (verifHeure())
        {
            super.acheter(o);
        }
        else
            System.out.println("Vous n'avez pas le droit de travailler à ces heures");
    }

    /**
     *  permet au tradeur de creer une offre dans la fourchette d'heure permise (utilise créer offre de AcheteurVendeur)
     * @param prix int prix de l'offre
     * @param produit Produit correspondant à la marchandise vendu
     * @param strategyChoixAcheteur Strategie de vente utilisé par le vendeur
     * @param marche Marche dans lequel l'offre est posté
     */
    @Override
    public void creerUneOffre(int prix, Produit produit, StrategyChoixAcheteur strategyChoixAcheteur, LivreDuMarche marche) {
        if (verifHeure()) {
            super.creerUneOffre(prix, produit, strategyChoixAcheteur, marche);
        }
        else
            System.out.println("Vous n'avez pas le droit de travailler à ces heures");
    }


}
