package marche.traitement.Marche;

import marche.traitement.FluxInformation.FluxInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class LivreDuMarche {


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
    }

    public static void enleverOffre(Offre o){
        livreMarche.remove(o);
        o.archiver();

    }

    public static void afficherLivre()
    {
        for (Offre o:livreMarche)
        {
            if (o.isValider())
            {
                System.out.println(o);
            }
        }
    }

    public List<Offre> getLivre() {
        return livreMarche;
    }

    public void ajouterFluxInformation(FluxInformation f){
        fluxInformations.add(f);
    }

    public void enleverFluxInformation(FluxInformation f){
        fluxInformations.remove(f);
    }

    public void notifierFluxInformations(Offre offre){
        for(FluxInformation f : fluxInformations){
            f.update(offre);
        }
    }


}
