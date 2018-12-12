package marche.traitement.Producteurs;

public class TestProducteur {

    public static void main(String[] args)
    {
        ProducteurDeViande pr = new ProducteurDeViande(1500,100);
        pr.getLimite();
        Apiculteur api = new Apiculteur(200,100);
        api.getLimite();
    }
}
