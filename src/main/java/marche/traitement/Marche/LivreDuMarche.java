package marche.traitement.Marche;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class LivreDuMarche {


    private List<Offre> livre;


    /**
     * Default constructor
     */
    public LivreDuMarche() {
    }

    /**
     * function ajouterOffre
     */
    public void ajouterOffre(Offre o)
    {
        livre.add(o);
    }

    public List<Offre> getLivre() {
        return livre;
    }
}