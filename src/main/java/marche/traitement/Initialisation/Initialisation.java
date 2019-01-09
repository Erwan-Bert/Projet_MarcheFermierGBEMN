package marche.traitement.Initialisation;

import marche.traitement.Acteurs.ChoixAcheteur.ChoixParOrdreArrivee;
import marche.traitement.Acteurs.Tradeur;
import marche.traitement.Acteurs.VendeurAcheteur;
import marche.traitement.Acteurs.controleur.ControleurAMF;
import marche.traitement.FluxInformation.FluxInformation;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Producteurs.*;
import marche.traitement.UnitedeProduction.*;

import java.time.LocalDate;
import java.util.ArrayList;

public final class Initialisation
{
    public static ArrayList<VendeurAcheteur> listeVendeurAcheteur = new ArrayList<>();
    public static ArrayList<UniteDeProduction> listeUniteDeProduction = new ArrayList<>();
    public static LivreDuMarche livreDuMarche = new LivreDuMarche("livre du Marché", new ControleurAMF(new ArrayList<String>()));
    public static ArrayList<FluxInformation> listeNewsLetter = new ArrayList<>();



    public static void init(){

        Apiculteur apiculteur = new Apiculteur(100, "Jean", 50);
        Arboriculteur arboriculteur = new Arboriculteur(200, "Pierre", 60);
        Horticulteur horticulteur = new Horticulteur(300, "Jacques", 70);
        ProducteurDeViande producteurDeViande = new ProducteurDeViande(400, "Bernard", 80);
        ProducteurLaitier producteurLaitier = new ProducteurLaitier(500, "Philippe", 90);


        UniteDeProduction uniteDeProductionApiculteur = new UniteDeProductionApiculteur("abeilles");
        uniteDeProductionApiculteur.ajouterMembre(apiculteur);
        uniteDeProductionApiculteur.produire(20, "miel", LocalDate.of(2019,2,12),apiculteur);
        UniteDeProduction uniteDeProductionArboriculteur = new UniteDeProductionArboriculteur("pommes");
        uniteDeProductionArboriculteur.ajouterMembre(arboriculteur);
        uniteDeProductionArboriculteur.produire(30, "pomme", LocalDate.of(2019,3,13),arboriculteur);
        UniteDeProduction uniteDeProductionHoriculteur = new UniteDeProductionHorticulteur("épinards");
        uniteDeProductionHoriculteur.ajouterMembre(horticulteur);
        uniteDeProductionHoriculteur.produire(40, "epinard", LocalDate.of(2019,4,14),horticulteur);
        UniteDeProduction uniteDeProductionViande = new UniteDeProductionProducteurDeViande("viandes");
        uniteDeProductionViande.ajouterMembre(producteurDeViande);
        uniteDeProductionViande.produire(20, "cochon", LocalDate.of(2019,5,15),producteurDeViande);
        uniteDeProductionViande.produire(30, "vache", LocalDate.of(2019,5,15),producteurDeViande);
        UniteDeProduction uniteDeProductionLaitiere = new UniteDeProductionLaitier("lait");
        uniteDeProductionLaitiere.ajouterMembre(producteurLaitier);
        uniteDeProductionLaitiere.produire(60, "lait", LocalDate.of(2019,6,16),producteurLaitier);
        uniteDeProductionLaitiere.produire(20, "fromage", LocalDate.of(2019,6,16),producteurLaitier);


        apiculteur.creerUneOffre(100, apiculteur.getElementStock(1), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 10);
        arboriculteur.creerUneOffre(200, arboriculteur.getElementStock(1), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 20);
        horticulteur.creerUneOffre(300, horticulteur.getElementStock(1), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 20);
        producteurDeViande.creerUneOffre(400, producteurDeViande.getElementStock(1), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 10);
        producteurDeViande.creerUneOffre(500, producteurDeViande.getElementStock(2), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 20);
        producteurLaitier.creerUneOffre(600, producteurLaitier.getElementStock(1), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 30);
        producteurLaitier.creerUneOffre(700, producteurLaitier.getElementStock(2), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 10);
        apiculteur.creerUneOffre(800, apiculteur.getElementStock(1), new ChoixParOrdreArrivee(), Initialisation.livreDuMarche, 5);


        Tradeur tradeur = new Tradeur("Jean-Edward", 15000);
        tradeur.acheter(Initialisation.livreDuMarche.getLivre().get(0));
        tradeur.acheter(Initialisation.livreDuMarche.getLivre().get(1));
        tradeur.acheter(Initialisation.livreDuMarche.getLivre().get(2));
        livreDuMarche.getControleur().choisirAcheteur(Initialisation.livreDuMarche.getLivre().get(0));
        livreDuMarche.getControleur().choisirAcheteur(Initialisation.livreDuMarche.getLivre().get(0));
        livreDuMarche.getControleur().choisirAcheteur(Initialisation.livreDuMarche.getLivre().get(0));




    }

}
