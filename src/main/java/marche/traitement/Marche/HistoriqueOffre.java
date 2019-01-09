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
	
	/**
     * Retourne la liste des archives
	 * @return historiqueOffres
     */
    public static List<Archive> getArchives() {
        return historiqueOffres ;
    }

	/**
     * Ajoute une offre a la liste des archives
	 * @param  archive
     */
    public static void addOffresArchives(Archive archive) {
        historiqueOffres .add(archive);
    }
}