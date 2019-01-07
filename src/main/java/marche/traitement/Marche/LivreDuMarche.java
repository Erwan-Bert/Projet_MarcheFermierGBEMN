package marche.traitement.Marche;

import marche.traitement.FluxInformation.FluxInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class LivreDuMarche {


    private List<Offre> livreMarche = new ArrayList<Offre>();
    private List<FluxInformation> fluxInformations = new ArrayList<FluxInformation>();
    private String nom ;

    /**
     * Default constructor
     */
    public LivreDuMarche(String nom)
    {
        this.nom = nom;
    }

    /**
     * function ajouterOffre
     */
    public void ajouterOffre(Offre o)
    {
        livreMarche.add(o);
        notifierFluxInformations(o);

    }

    public void enleverOffre(Offre o){
        livreMarche.remove(o);
        o.archiver();

    }

    public void afficherLivre()
    {
        for (Offre o:livreMarche)
        {
            System.out.println(o);

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
