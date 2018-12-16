package marche.traitement.Marche;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class HistoriqueOffre {

    private List<Offre> offresArchives = new ArrayList<Offre>();

    /**
     * Default constructor
     */
    public HistoriqueOffre() {
    }

    public List<Offre> getOffresArchives() {
        return offresArchives;
    }

    public void addOffresArchives(Offre offreArchive) {
        this.offresArchives.add(offreArchive);
    }
}