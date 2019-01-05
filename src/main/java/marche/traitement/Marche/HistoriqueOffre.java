package marche.traitement.Marche;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class HistoriqueOffre {

    private static List<Archive> historiqueOffres = new ArrayList<Archive>();

    /**
     * Default constructor
     */
    private HistoriqueOffre()
    {
    }

    public static List<Archive> getArchives() {
        return historiqueOffres ;
    }

    public static void addOffresArchives(Archive Archive) {
        historiqueOffres .add(Archive);
    }
}