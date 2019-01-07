package marche.traitement.Produit;

import java.time.LocalDate;

public class TestProduit {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2015, 8, 11);
        date1=date1.plusDays(75);
        Produit produit1 = new Miel(1,date1,"killogrames");
        System.out.println(produit1.dateDePeremption);
    }
    }
