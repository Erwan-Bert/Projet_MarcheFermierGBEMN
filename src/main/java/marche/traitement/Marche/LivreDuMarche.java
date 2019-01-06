package marche.traitement.Marche;

import marche.traitement.FluxInformation.FluxInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public final class LivreDuMarche {


    private static List<Offre> livreMarche = new ArrayList<Offre>();
    private static List<FluxInformation> fluxInformations = new ArrayList<FluxInformation>();

    /**
     * Default constructor
     */
    private LivreDuMarche()
    {

    }

    /**
     * function ajouterOffre
     */
    public static void ajouterOffre(Offre o)
    {
        livreMarche.add(o);
        LivreDuMarche.notifierFluxInformations(o);

    }

    public static void enleverOffre(Offre o){
        livreMarche.remove(o);
        o.archiver();

    }

    public static void afficherLivre()
    {
        for (Offre o:livreMarche)
        {
            System.out.println(o);

        }
    }

    public static List<Offre> getLivre() {
        return livreMarche;
    }

    public static void ajouterFluxInformation(FluxInformation f){
        fluxInformations.add(f);
    }

    public static void enleverFluxInformation(FluxInformation f){
        fluxInformations.remove(f);
    }

    public static void notifierFluxInformations(Offre offre){
        for(FluxInformation f : fluxInformations){
            f.update(offre);
        }
    }


}
