package marche.affichage;

import marche.traitement.Initialisation.Initialisation;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.Offre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AffichageTerminal
{
    public static String menuProduire(int avancement) {

        String choix = "";
        if (avancement == 1)
            System.out.println("Entrez le nom de votre produit");
        else if (avancement == 2)
            System.out.println("Entrez la quantite produite (en litre ou kilo selon votre produit)");
        else if (avancement == 3)
            System.out.println("Entrez la date de péremption du produit sous la forme jj/mm/aaaa");
        else if (avancement == 4)
            System.out.println("Entrez fini si vous avez fini ou autre produit si vous avez d'autres produits à enregistrer");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static String menuPrincipal()
    {
        String choix = "";
        System.out.println("Entrez ajouter membre si vous voulez ajouter un membre à une unité de production.\n" +
                    "Entrez produire si vous voulez ajouter des produits à votre compte.\n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static String menuAjouterMembre(int avancement)
    {
        String choix = "";
        if (avancement == 1)
            System.out.println("Entrez le nom du producteur que vous voulez ajouter");
        else if (avancement == 2)
            System.out.println("Entrez le nom de l'unité de production dans laquelle vous voulez l'ajouter, puis réappuyer sur entrer");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    private static ArrayList<String> gestionMenuProduire()
    {
        ArrayList<String> elements = new ArrayList<>();
        String temp = "";
        String produit = "";
        String quantite = "";
        String peremption = "";
        int avancement = 1;
        while (!temp.equals("fini"))
        {
            temp = menuProduire(avancement);
            if (avancement == 1)
                produit = temp;
            else if (avancement == 2)
                quantite = temp;
            else if (avancement == 3)
                System.out.println("date = temp");
            else if (avancement == 4 && temp.equals("autre produit"))
            {
                avancement = 0;
            }
            avancement += 1;
        }
        elements.add(produit);
        elements.add(quantite);
        elements.add(peremption);
        return elements;
    }

    public static void affichageParticipants()
    {
        System.out.println(Initialisation.listeProducteur);
    }

    public static void affichageCatalogue()
    {
        System.out.println(Initialisation.livreDuMarche);
    }

    public static void affichageHistorique()
    {
        System.out.println(HistoriqueOffre.getArchives());
    }

    public static void affichageCotation()
    {
        int nombreOffreMiel = 0;
        double sommePrixMiel = 0;
        double moyennePrixMiel;

        int nombreOffrePomme = 0;
        double sommePrixPomme = 0;
        double moyennePrixPomme;

        int nombreOffreEpinard = 0;
        double sommePrixEpinard = 0;
        double moyennePrixEpinard;

        int nombreOffreVache = 0;
        double sommePrixVache = 0;
        double moyennePrixVache;

        int nombreOffreCochon = 0;
        double sommePrixCochon = 0;
        double moyennePrixCochon;

        int nombreOffreLait = 0;
        double sommePrixLait = 0;
        double moyennePrixLait;

        int nombreOffreFromage = 0;
        double sommePrixFromage = 0;
        double moyennePrixFromage;
        for (Offre offre: Initialisation.livreDuMarche.getLivre())
        {
            if (offre.getProduit().getNom().equals("miel"))
            {
                nombreOffreMiel += 1;
                sommePrixMiel += offre.getPrix() / offre.getProduit().getQuantite();
            }
            else if (offre.getProduit().getNom().equals("pomme"))
            {
                nombreOffrePomme += 1;
                sommePrixPomme += offre.getPrix() / offre.getProduit().getQuantite();
            }
            else if (offre.getProduit().getNom().equals("épinards"))
            {
                nombreOffreEpinard += 1;
                sommePrixEpinard += offre.getPrix() / offre.getProduit().getQuantite();
            }
            else if (offre.getProduit().getNom().equals("vache"))
            {
                nombreOffreVache += 1;
                sommePrixVache += offre.getPrix() / offre.getProduit().getQuantite();
            }
            else if (offre.getProduit().getNom().equals("cochon"))
            {
                nombreOffreCochon += 1;
                sommePrixCochon += offre.getPrix() / offre.getProduit().getQuantite();
            }
            else if (offre.getProduit().getNom().equals("lait"))
            {
                nombreOffreLait += 1;
                sommePrixLait += offre.getPrix() / offre.getProduit().getQuantite();
            }
            else if (offre.getProduit().getNom().equals("fromage"))
            {
                nombreOffreFromage += 1;
                sommePrixFromage += offre.getPrix() / offre.getProduit().getQuantite();
            }
        }
        moyennePrixMiel = sommePrixMiel / nombreOffreMiel;
        moyennePrixPomme = sommePrixPomme / nombreOffrePomme;
        moyennePrixEpinard = sommePrixEpinard / nombreOffreEpinard;
        moyennePrixVache = sommePrixVache / nombreOffreVache;
        moyennePrixCochon = sommePrixCochon / nombreOffreCochon;
        moyennePrixLait = sommePrixLait / nombreOffreLait;
        moyennePrixFromage = sommePrixFromage / nombreOffreFromage;
        StringBuilder affichagePrix = new StringBuilder();
        affichagePrix.append("Prix actuel moyen du miel par kilo : " + moyennePrixMiel + "€\n");
        affichagePrix.append("Prix actuel moyen des pommes par kilo : " + moyennePrixPomme + "€\n");
        affichagePrix.append("Prix actuel moyen des épinards par kilo : " + moyennePrixEpinard + "€\n");
        affichagePrix.append("Prix actuel moyen de la viande de vache par kilo : " + moyennePrixVache + "€\n");
        affichagePrix.append("Prix actuel moyen de la viande de cochon par kilo : " + moyennePrixCochon + "€\n");
        affichagePrix.append("Prix actuel moyen du lait par kilo : " + moyennePrixLait + "€\n");
        affichagePrix.append("Prix actuel moyen du fromage par kilo : " + moyennePrixFromage + "€");
        System.out.println(affichagePrix.toString());
    }

    public static void gestionMenuPricipal()
    {
        ArrayList<String> parametreProduit;
        String temp = "";
        int avancement = 1;
        while (!temp.equals("ajouter membre") || !temp.equals("produire"))
        {
            temp = menuPrincipal();
        }
        if (temp.equals("ajouter membre"))
        {
            while (!temp.equals(""))
                temp = menuAjouterMembre(avancement);

        }
        else
            parametreProduit = new ArrayList<>(gestionMenuProduire());


    }


}
