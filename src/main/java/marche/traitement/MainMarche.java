package marche.traitement;


import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;
import marche.traitement.UnitedeProduction.UniteDeProduction;
import marche.traitement.UnitedeProduction.UniteDeProductionApiculteur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class MainMarche {
    public static void main(String[] args)
    {
        Produit pomme = new Pomme(1, LocalDate.now().plusDays(14),"Tonne");







        /*
        String temp ="";
        int avancement = 1;
        String produit = "";
        Integer quantite = 0;
        String peremption = "";
        while (!temp.equals("fini"))
        {
            temp = menu(avancement);
            if (avancement == 1)
                produit = temp;
            else if (avancement == 2)
                quantite = Integer.parseInt(temp);
            else if (avancement == 3)
                peremption = temp;
            else if (avancement == 4 && temp.equals("autre produit"))
            {
                System.out.println(UniteDeProduction.fabriquer(produit, quantite, peremption));
                avancement = 0;
            }
            avancement += 1;
        }
        System.out.println(UniteDeProduction.fabriquer(produit, quantite, peremption));
    }

    private static String menu(int avancement) {

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
    */
    }
}
