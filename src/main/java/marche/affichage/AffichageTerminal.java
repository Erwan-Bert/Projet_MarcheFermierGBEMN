package marche.affichage;

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
            while (!temp.equals(""))
                temp = menuAjouterMembre(avancement);
        else
            parametreProduit = new ArrayList<>(gestionMenuProduire());


    }


}
