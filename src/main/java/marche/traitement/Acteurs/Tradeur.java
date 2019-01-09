package marche.traitement.Acteurs;

import marche.traitement.Acteurs.ChoixAcheteur.StrategyChoixAcheteur;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Produit.Produit;

import java.util.Calendar;


public class Tradeur extends VendeurAcheteur
{
    private boolean actif = false;
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
            this.actif = true;
        }
        else
        {
            this.actif = false;
        }
        return this.actif;
    }

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

    @Override
    public void creerUneOffre(int prix, Produit produit, StrategyChoixAcheteur strategyChoixAcheteur, LivreDuMarche marche) throws ArithmeticException, IllegalArgumentException {
        if (verifHeure()) {
            super.creerUneOffre(prix, produit, strategyChoixAcheteur, marche);
        }
        else
            System.out.println("Vous n'avez pas le droit de travailler à ces heures");
    }


}
