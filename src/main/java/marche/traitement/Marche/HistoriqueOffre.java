package marche.traitement.Marche;

import java.util.ArrayList;

/**
 * 
 */
public class HistoriqueOffre {

    private ArrayList<Offre> offresArchives = new ArrayList<Offre>();

    /**
     * Default constructor
     */
    public HistoriqueOffre() {
    }

    public ArrayList<Offre> getOffresArchives() {
        return offresArchives;
    }

    public void addOffresArchives(Offre offreArchive) {
        this.offresArchives.add(offreArchive);
    }
}