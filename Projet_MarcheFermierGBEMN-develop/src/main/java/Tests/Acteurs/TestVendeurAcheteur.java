package Tests.Acteurs;

import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Producteurs.ProducteurLaitier;
import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Produit;
import marche.traitement.Produit.Viande.vache;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestVendeurAcheteur {



    @Test
    public void ajouterAuStock_Basic(){
        Produit produit = new Pomme(10, LocalDate.now(),"Tonne");
        VendeurAcheteur vendeurAcheteur = new ProducteurLaitier(1000,"Chams",100);

        vendeurAcheteur.ajouterAuStock(produit);
        List<Produit> stocks = vendeurAcheteur.getStocks();
        Produit produitStocke = stocks.get(0);
        assertEquals(produitStocke, produit );
    }

    /**
     * cas d'un produit déjà dans le stock de type différent
     */
    @Test
    public void ajouterAuStock_ProduitDejaDansLeStock(){
        Produit produitInitial = new vache(10, LocalDate.now(),"Tonne");
        Produit produit = new Pomme(10, LocalDate.now(),"Tonne");
        VendeurAcheteur vendeurAcheteur = new ProducteurLaitier(1000,"Chams",100);

        vendeurAcheteur.ajouterAuStock(produitInitial);
        vendeurAcheteur.ajouterAuStock(produit); // deuxième ajout d'une pomme
        List<Produit> stocks = vendeurAcheteur.getStocks();
        Produit produitStocke = stocks.get(0);
        assertEquals(10 ,produitStocke.getQuantite()  );
        assertEquals( 2, stocks.size() );
    }

    /**
     * cas d'un produit déjà dans le stock mais avec date de péremption différente
     */
    @Test
    public void ajouterAuStock_ProduitDejaDansLeStockMauvaiseDate(){
        Produit produit = new Pomme(10, LocalDate.now(),"Tonne");
        Produit produit1 = new Pomme(10, LocalDate.now().plusDays(1),"Tonne");
        VendeurAcheteur vendeurAcheteur = new ProducteurLaitier(1000,"Chams",100);

        vendeurAcheteur.ajouterAuStock(produit);
        vendeurAcheteur.ajouterAuStock(produit1); // deuxième ajout d'une pomme à date de péremption différente

        List<Produit> stocks = vendeurAcheteur.getStocks();
        Produit produitStocke = stocks.get(0);
        System.out.println(stocks);
        assertEquals( 2, stocks.size() );
    }
    /**
     * cas d'un produit déjà dans le stock mais avec unité différente
     */
    @Test
    public void ajouterAuStock_ProduitDejaDansLeStockMauvaiseUnite(){
        Produit produit = new Pomme(10, LocalDate.now(),"mole");
        Produit produit1 = new Pomme(10, LocalDate.now(),"Tonne");
        VendeurAcheteur vendeurAcheteur = new ProducteurLaitier(1000,"Chams",100);

        vendeurAcheteur.ajouterAuStock(produit);
        vendeurAcheteur.ajouterAuStock(produit1); // deuxième ajout d'une pomme à date de péremption différente

        List<Produit> stocks = vendeurAcheteur.getStocks();
        Produit produitStocke = stocks.get(0);
        System.out.println(stocks);
        assertEquals( 2, stocks.size() );
    }



}
