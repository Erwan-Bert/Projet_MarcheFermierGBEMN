package marche.affichage;

import marche.traitement.Acteurs.Acteur;
import marche.traitement.Acteurs.CentraleAchat;
import marche.traitement.Acteurs.Tradeur;
import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.FluxInformation.FluxInformation;
import marche.traitement.FluxInformation.NewsLetter;
import marche.traitement.Initialisation.Initialisation;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.Offre;
import marche.traitement.Producteurs.*;
import marche.traitement.Producteurs.DecorateurProducteur.ProducteurBio;
import marche.traitement.UnitedeProduction.*;
import marche.traitement.UnitedeProduction.UnitedeProdLabel.UniteDeProductionBio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class AffichageTerminal
{
    public static String menuProduire(int avancement) {

        String choix = "";
        if (avancement == 1)
            System.out.println("Entrez le nom de votre produit(miel , pomme , epinnard ,vache ,cochon,lait,frommage");
        else if (avancement == 2)
            System.out.println("Entrez la quantite produite (en litre ou kilo selon votre produit)");
        else if (avancement == 3)
            System.out.println("Dans combien de jour votre produit se périme?");
        else if (avancement == 4)
            System.out.println("Entrez le nom du producteur");
        else if (avancement == 5)
            System.out.println("Entrez le nom de l'unité de production");
        else if (avancement == 6)
            System.out.println("Entrez fini si vous avez fini ou autre produit si vous avez d'autres produits à enregistrer");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static int menuPrincipal()
    {
        String choix = "";
        String espace = "------------------------------------------------------------------------------------\n";
        System.out.println("Entrez 1 pour ajouter membre à une unité de production.\n" + espace+
                    "Entrez 2 si vous voulez produire des produits.\n" + espace+
                "Entrez 3 si vous voulez voir la liste des producteurs.\n" + espace+
                "Entrez 4 si vous voulez voir toutes les offres.\n" + espace+
                "Entrez 5 si vous voulez voir l'historique des offres.\n" + espace+
                "Entrez 6 si vous voulez voir le prix moyen de tous les produits du marché.\n"+ espace+
                "Entrez 7 si vous voulez créer de nouveaux producteurs.\n" + espace+
                "Entrez 8 si vous voulez créer de nouveaux traders.\n" + espace+
                "Entrez 9 si vous voulez créer de nouvelles unité de production.\n" + espace+
                "Entrez 10 si vous voulez créer des centrales d'achat\n" + espace+
                "Entrez 11 si vous voulez créer des NewsLetter\n" + espace+
                "Entrez 12 si vous voulez abonner quelqu'un à une newsLetter\n"+espace
                +"Entrez 13 si vous voulez voir la liste des unités de production");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return parseInt(choix);
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
        String unite = "";
        String producteur = "";
        int avancement = 1;
        while (!temp.equals("fini"))
        {
            temp = menuProduire(avancement);
            if (avancement == 1)
                produit = temp;
            else if (avancement == 2)
                quantite = temp;
            else if (avancement == 3)
                peremption = temp;
            else if (avancement == 4)
                producteur = temp;
            else if (avancement == 5)
                unite = temp;
            else if (avancement == 6 && temp.equals("autre produit"))
            {
                avancement = 0;
            }
            avancement += 1;
        }
        elements.add(produit);
        elements.add(quantite);
        elements.add(peremption);
        elements.add(unite);
        elements.add(producteur);
        return elements;
    }

    public static void affichageParticipants()
    {
        System.out.println(Initialisation.listeVendeurAcheteur);
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

    public static String menuCreationProducteur(int avancement)
    {
            String choix = "";
            if (avancement == 1)
                System.out.println("Entrez le nom du producteur que vous voulez créer (pour créer un producteur bio il faut d'abord créer un producteur normal)");
            else if (avancement == 2)
                System.out.println("Entrez son solde");
            else if (avancement == 3)
                System.out.println("Entrez sa limite de stockage");
            else if (avancement == 4)
                System.out.println("Entrez le type de sa production");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                choix = in.readLine();
            } catch (IOException e) {
                System.out.println("Problème de saisie");
            }
            return choix;
    }

    public static String menuCreationTrader(int avancement)
    {
        String choix = "";
        if (avancement == 1)
            System.out.println("Entrez le nom du Trader que vous voulez créer");
        else if (avancement == 2)
            System.out.println("Entrez son solde");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static ArrayList<String> gestionCreationTrader()
    {
        ArrayList<String> elements = new ArrayList<>();
        String temp = "";
        String solde = "";
        String nom = "";
        int avancement = 1;
        while (avancement != 3)
        {
            temp = menuCreationTrader(avancement);
            if (avancement == 1)
                nom = temp;
            else if (avancement == 2)
                solde = temp;
            ++avancement;
        }
        elements.add(nom);
        elements.add(solde);
        return elements;
    }

    public static ArrayList<String> gestionCreationProducteur()
    {
        ArrayList<String> elements = new ArrayList<>();
        String temp = "";
        String solde = "";
        String nom = "";
        String limite = "";
        String type = "";
        int avancement = 1;
        System.out.println("Les producteurs que vous pouvez créer sont : arboriculteur|horticulteur|producteur de viande|producteur laitier|producteur bio");
        while (avancement != 5)
        {
            temp = menuCreationProducteur(avancement);
            if (avancement == 1)
                nom = temp;
            else if (avancement == 2)
                solde = temp;
            else if (avancement == 3)
                limite = temp;
            else if (avancement == 4)
                type = temp;
            ++avancement;
        }
        elements.add(nom);
        elements.add(solde);
        elements.add(limite);
        elements.add(type);
        return elements;
    }

    public static String menuCreationUniteProduction(int avancement)
    {
        String choix = "";
        if (avancement == 1)
            System.out.println("Entrez le nom de l'unité de production que vous voulez créer (pour faire une unité de production bio il faut d'abord en créer une normale)");
        if (avancement == 2)
            System.out.println("Entrez le type de ses productions");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static ArrayList<String> gestionCreationUniteProduction()
    {
        ArrayList<String> elements = new ArrayList<>();
        String temp = "";
        String nom = "";
        String type = "";
        int avancement = 1;
        System.out.println("Les unités de production que vous pouvez créer sont : apiculteur|arboriculteur|horticulteur|viande|laitier|bio  ");
        while (avancement != 3)
        {
            temp = menuCreationUniteProduction(avancement);
            if (avancement == 1)
                nom = temp;
            else if (avancement == 2)
                type = temp;
            ++avancement;
        }
        elements.add(nom);
        elements.add(type);
        return elements;
    }

    public static String menuCreationCentral()
    {
        String choix = "";
        System.out.println("Entrez le nom de la centrale d'achat que vous voulez créer");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static String menuCreationNewsLetter()
    {
        String choix = "";
        System.out.println("Entrez le nom de la newsletter que vous voulez créer");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static String menuAjouterAbonner(int avancement)
    {
        String choix = "";
        if (avancement == 1)
            System.out.println("Entrez le nom de la personne que vous voulez abonner");
        if (avancement == 2)
            System.out.println("Entrez le nom de la NewsLetter");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            choix = in.readLine();
        } catch (IOException e) {
            System.out.println("Problème de saisie");
        }
        return choix;
    }

    public static ArrayList<String> gestionAjouterAbonner()
    {
        ArrayList<String> elements = new ArrayList<>();
        String temp = "";
        String nomAbo = "";
        String nomNews = "";
        int avancement = 1;
        while (avancement != 3)
        {
            temp = menuAjouterAbonner(avancement);
            if (avancement == 1)
                nomAbo = temp;
            else if (avancement == 2)
                nomNews = temp;
            ++avancement;
        }
        elements.add(nomAbo);
        elements.add(nomNews);
        return elements;
    }

    public static void gestionMenuPricipal()
    {
        ArrayList<String> parametre;
        int tempInt;
        String tempString = "pas vide";
        int avancement = 1;
        tempInt = menuPrincipal();
        switch (tempInt)
        {
            case 1 :
                String nom1 = "";
                String nom2 = "";
                while (!tempString.equals("") && avancement != 3)
                {
                    tempString = menuAjouterMembre(avancement);
                    if (avancement == 1)
                        nom1 = tempString;
                    if (avancement == 2)
                        nom2 = tempString;
                    ++avancement;
                }
                for (UniteDeProduction unite: Initialisation.listeUniteDeProduction)
                {
                    if (unite.getNom().equals(nom2))
                        for (VendeurAcheteur va: Initialisation.listeVendeurAcheteur)
                        {
                            if (va.getNom().equals(nom1))
                                unite.ajouterMembre((Producteur) va);
                        }
                }
                break;
            case 2 :
                parametre = new ArrayList<>(gestionMenuProduire());
                System.out.println(parametre);
                for (UniteDeProduction unite: Initialisation.listeUniteDeProduction)
                {
                    if (unite.getNom().equals(parametre.get(3)))
                    {
                        for (Producteur p : unite.getMembre()) {
                            if (p.getNom().equals(parametre.get(4)))
                                unite.produire(parseInt(parametre.get(1)), parametre.get(0), LocalDate.now().plusDays(parseInt(parametre.get(2))), p);
                        }
                    }
                }
                break;
            case 3 : affichageParticipants();
                break;
            case 4 : affichageCatalogue();
                break;
            case 5 : affichageHistorique();
                break;
            case 6 : affichageCotation();
                break;
            case 7 :
                parametre = gestionCreationProducteur();
                if (parametre.get(3).equals("apiculteur"))
                {
                    Producteur p = new Apiculteur(parseInt(parametre.get(1)), parametre.get(0), parseInt(parametre.get(2)));
                }
                else if (parametre.get(3).equals("arboriculteur"))
                {
                    Producteur p = new Arboriculteur(parseInt(parametre.get(1)), parametre.get(0), parseInt(parametre.get(2)));
                }
                else if (parametre.get(3).equals("horticulteur"))
                {
                    Producteur p = new Horticulteur(parseInt(parametre.get(1)), parametre.get(0), parseInt(parametre.get(2)));
                }
                else if (parametre.get(3).equals("producteur de viande"))
                {
                    Producteur p = new ProducteurDeViande(parseInt(parametre.get(1)), parametre.get(0), parseInt(parametre.get(2)));
                }
                else if (parametre.get(3).equals("producteur laitier"))
                {
                    Producteur p = new ProducteurLaitier(parseInt(parametre.get(1)), parametre.get(0), parseInt(parametre.get(2)));
                }
                else if (parametre.get(3).equals("producteur bio"))
                {
                    for (VendeurAcheteur va: Initialisation.listeVendeurAcheteur)
                    {
                        if (va.getNom().equals(parametre.get(0)))
                        {
                            Producteur pBio = new ProducteurBio((Producteur) va);
                        }
                    }
                }
                break;
            case 8 :
                parametre = gestionCreationTrader();
                VendeurAcheteur trader = new Tradeur(parametre.get(0), parseInt(parametre.get(1)));
                break;
            case 9 :
                parametre = gestionCreationUniteProduction();
                if (parametre.get(1).equals("apiculteur")){
                    UniteDeProduction up = new UniteDeProductionApiculteur(parametre.get(0));
                }
                else if (parametre.get(1).equals("arboriculteur")){
                    UniteDeProduction up = new UniteDeProductionArboriculteur(parametre.get(0));
                }
                else if (parametre.get(1).equals("horticulteur")){
                    UniteDeProduction up = new UniteDeProductionHorticulteur(parametre.get(0));
                }
                else if (parametre.get(1).equals("viande")){
                    UniteDeProduction up = new UniteDeProductionProducteurDeViande(parametre.get(0));
                }
                else if (parametre.get(1).equals("laitier")){
                    UniteDeProduction up = new UniteDeProductionLaitier(parametre.get(0));
                }
                else if (parametre.get(1).equals("bio")){
                    for (UniteDeProduction up: Initialisation.listeUniteDeProduction)
                    {
                        if (up.getNom().equals(parametre.get(0)))
                        {
                            UniteDeProduction upBio = new UniteDeProductionBio(up);
                        }
                    }
                }
                break;
            case 10 :
                tempString = menuCreationCentral();
                Acteur central = new CentraleAchat(tempString);
                break;
            case 11 :
                tempString = menuCreationNewsLetter();
                FluxInformation news = new NewsLetter(tempString);
                break;
            case 12 :
                parametre = gestionAjouterAbonner();
                for (FluxInformation fi: Initialisation.listeNewsLetter)
                {
                    if (fi.getNom().equals(parametre.get(1)))
                    {
                        for (VendeurAcheteur va: Initialisation.listeVendeurAcheteur)
                        {
                            if (va.getNom().equals(parametre.get(0)))
                                fi.ajouterAbonne(va);
                        }
                    }
                }
                break;
            case 13 :
                System.out.println(Initialisation.listeUniteDeProduction);
            default:
                System.out.println("Veuillez écrire l'un des nombres proposés");
        }
    }
}
