package marche.traitement.Marche;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class LivreDuMarche {


    private static List<Offre> livreMarche = new ArrayList<>();


    /**
     * Default constructor
     */
    private LivreDuMarche()
    {

    }

    /**
     * function ajouterOffre
     */
    public void ajouterOffre(Offre o)
    {
        livreMarche.add(o);
    }

    public void enleverOffre(Offre o){
        livreMarche.remove(o);
        HistoriqueOffre.addOffresArchives(o);

    }

    public List<Offre> getLivre() {
        return livreMarche;
    }
}