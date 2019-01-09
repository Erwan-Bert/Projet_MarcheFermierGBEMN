package marche.traitement.Initialisation;

import marche.traitement.Acteurs.ChoixAcheteur.ChoixParOrdreArrivee;
import marche.traitement.Acteurs.ChoixAcheteur.ChoixParPlusPetitSolde;
import marche.traitement.Acteurs.Tradeur;
import marche.traitement.Acteurs.controleur.ControleurAMF;
import marche.traitement.Marche.Archive;
import marche.traitement.Marche.HistoriqueOffre;
import marche.traitement.Marche.LivreDuMarche;
import marche.traitement.Marche.Offre;
import marche.traitement.Producteurs.*;
import marche.traitement.Produit.Epinards;
import marche.traitement.Produit.Fruit.Pomme;
import marche.traitement.Produit.Miel;
import marche.traitement.Produit.ProduitsLaitiers.Lait;
import marche.traitement.Produit.Viande.Cochon;
import marche.traitement.Produit.Viande.Vache;
import marche.traitement.UnitedeProduction.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Initialisation
{
    public static ArrayList<Producteur> listeProducteur = new ArrayList<>();
    public static ArrayList<UniteDeProduction> listeUniteDeProduction = new ArrayList<>();
    public static LivreDuMarche livreDuMarche = new LivreDuMarche("livre du Marché", new ControleurAMF(null));

    static
    {
        Apiculteur apiculteur = new Apiculteur(100, "Jean", 50);
        Arboriculteur arboriculteur = new Arboriculteur(200, "Pierre", 60);
        Horticulteur horticulteur = new Horticulteur(300, "Jacques", 70);
        ProducteurDeViande producteurDeViande = new ProducteurDeViande(400, "Bernard", 80);
        ProducteurLaitier producteurLaitier = new ProducteurLaitier(500, "Philippe", 90);
        listeProducteur.add(apiculteur);
        listeProducteur.add(arboriculteur);
        listeProducteur.add(horticulteur);
        listeProducteur.add(producteurDeViande);
        listeProducteur.add(producteurLaitier);

        UniteDeProduction uniteDeProductionApiculteur = new UniteDeProductionApiculteur("les abeilles");
        uniteDeProductionApiculteur.ajouterMembre(apiculteur);
        uniteDeProductionApiculteur.produire(20, "miel", LocalDate.of(2019,2,12),apiculteur);
        UniteDeProduction uniteDeProductionArboriculteur = new UniteDeProductionArboriculteur("les pommes");
        uniteDeProductionArboriculteur.ajouterMembre(arboriculteur);
        uniteDeProductionArboriculteur.produire(30, "pomme", LocalDate.of(2019,3,13),arboriculteur);
        UniteDeProduction uniteDeProductionHoriculteur = new UniteDeProductionHorticulteur("les épinards");
        uniteDeProductionHoriculteur.ajouterMembre(horticulteur);
        uniteDeProductionHoriculteur.produire(40, "epinard", LocalDate.of(2019,4,14),horticulteur);
        UniteDeProduction uniteDeProductionViande = new UniteDeProductionProducteurDeViande("les viandes");
        uniteDeProductionViande.ajouterMembre(producteurDeViande);
        uniteDeProductionViande.produire(20, "cochon", LocalDate.of(2019,5,15),producteurDeViande);
        uniteDeProductionViande.produire(30, "vache", LocalDate.of(2019,5,15),producteurDeViande);
        UniteDeProduction uniteDeProductionLaitiere = new UniteDeProductionLaitier("le lait");
        uniteDeProductionLaitiere.ajouterMembre(producteurLaitier);
        uniteDeProductionLaitiere.produire(60, "lait", LocalDate.of(2019,6,16),producteurLaitier);

        listeUniteDeProduction.add(uniteDeProductionApiculteur);
        listeUniteDeProduction.add(uniteDeProductionArboriculteur);
        listeUniteDeProduction.add(uniteDeProductionHoriculteur);
        listeUniteDeProduction.add(uniteDeProductionViande);
        listeUniteDeProduction.add(uniteDeProductionLaitiere);


        Offre venteMiel1 = new Offre(100, new Miel(5, apiculteur.getElementStock(1).getDateDePeremption(), apiculteur.getElementStock(1).getUnite()), apiculteur, new ChoixParOrdreArrivee(), livreDuMarche);
        Offre venteMiel2 = new Offre(100, new Miel(5, apiculteur.getElementStock(1).getDateDePeremption(), apiculteur.getElementStock(1).getUnite()), apiculteur, new ChoixParOrdreArrivee(), livreDuMarche);
        Offre venteMiel3 = new Offre(100, new Miel(5, apiculteur.getElementStock(1).getDateDePeremption(), apiculteur.getElementStock(1).getUnite()), apiculteur, new ChoixParOrdreArrivee(), livreDuMarche);
        Offre venteMiel4 = new Offre(100, new Miel(5, apiculteur.getElementStock(1).getDateDePeremption(), apiculteur.getElementStock(1).getUnite()), apiculteur, new ChoixParOrdreArrivee(), livreDuMarche);
        Offre ventePomme = new Offre(200, new Pomme(20, arboriculteur.getElementStock(1).getDateDePeremption(), arboriculteur.getElementStock(1).getUnite()), arboriculteur, new ChoixParOrdreArrivee(), livreDuMarche);
        Offre venteEpinard = new Offre(300, new Epinards(30, horticulteur.getElementStock(1).getDateDePeremption(), horticulteur.getElementStock(1).getUnite()), horticulteur, new ChoixParPlusPetitSolde(), livreDuMarche);
        Offre venteCochon = new Offre(400, new Cochon(10, producteurDeViande.getElementStock(1).getDateDePeremption(), producteurDeViande.getElementStock(1).getUnite()), producteurDeViande, new ChoixParOrdreArrivee(), livreDuMarche);
        Offre venteVache = new Offre(500, new Vache(10, producteurDeViande.getElementStock(2).getDateDePeremption(), producteurDeViande.getElementStock(2).getUnite()), producteurDeViande, new ChoixParPlusPetitSolde(), livreDuMarche);
        Offre venteLait = new Offre(600, new Lait(producteurLaitier.getElementStock(1).getQuantite(), producteurLaitier.getElementStock(1).getDateDePeremption(), producteurLaitier.getElementStock(1).getUnite()), producteurLaitier, new ChoixParPlusPetitSolde(), livreDuMarche);
        livreDuMarche.ajouterOffre(venteMiel1);
        livreDuMarche.ajouterOffre(venteMiel2);
        livreDuMarche.ajouterOffre(venteMiel3);
        livreDuMarche.ajouterOffre(venteMiel4);
        livreDuMarche.ajouterOffre(ventePomme);
        livreDuMarche.ajouterOffre(venteEpinard);
        livreDuMarche.ajouterOffre(venteCochon);
        livreDuMarche.ajouterOffre(venteVache);
        livreDuMarche.ajouterOffre(venteLait);

        Tradeur tradeur = new Tradeur("Jean-Edward", 15000);
        tradeur.acheter(venteMiel1);
        tradeur.acheter(venteMiel2);
        tradeur.acheter(venteMiel3);
        Archive archiveVenteMiel1 = new Archive(tradeur,venteMiel1,LocalDate.of(2019,1,1));
        Archive archiveVenteMiel2 = new Archive(tradeur,venteMiel2,LocalDate.of(2019,1,2));
        Archive archiveVenteMiel3 = new Archive(tradeur,venteMiel3,LocalDate.of(2019,1,3));
        HistoriqueOffre.addOffresArchives(archiveVenteMiel1);
        HistoriqueOffre.addOffresArchives(archiveVenteMiel2);
        HistoriqueOffre.addOffresArchives(archiveVenteMiel3);



    }

}
