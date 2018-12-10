package marche.traitement.Producteurs;

public class TestProducteur {

    public static void main(String[] args)
    {
        ProducteurDeViande pr = new ProducteurDeViande(1500);
        ProducteurBio prb = new ProducteurBio(pr);
        prb.getLimite();
        prb.certifierBio();
        Apiculteur api = new Apiculteur(200);
        api.getLimite();
    }
}
