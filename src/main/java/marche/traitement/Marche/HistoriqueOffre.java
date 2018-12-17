package marche.traitement.Marche;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class HistoriqueOffre {

    private static List<Offre> historiqueOffres = new ArrayList<Offre>();

    /**
     * Default constructor
     */
    private HistoriqueOffre()
    {
    }

    public static List<Offre> getOffresArchives() {
        return historiqueOffres ;
    }

    public static void addOffresArchives(Offre offreArchive) {
        historiqueOffres .add(offreArchive);
    }
}