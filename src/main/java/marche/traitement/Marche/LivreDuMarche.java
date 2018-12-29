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
}