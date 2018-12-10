package marche.traitement.Marche;

import java.util.ArrayList;

/**
 * 
 */
public class LivreDuMarche {


    private ArrayList<Offre> livre;


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

    public ArrayList<Offre> getLivre() {
        return livre;
    }
}