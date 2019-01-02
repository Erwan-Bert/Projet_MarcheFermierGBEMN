package marche.traitement.Acteurs;

import java.util.ArrayList;
import java.util.Collection;

public class CentraleAchat extends Acteur
{
    private int pourcentage;
    private String nom;
    private Collection<Acteur> membres;

    CentraleAchat (String nom)
    {
        this.nom = nom;
        membres = new ArrayList<>();
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void ajouterMembres(Acteur membre)
    {
        membres.add(membre);
        membre.setCentraleAchat(this);
    }

    public void enleverMembre(Acteur membre)
    {
        membres.remove(membre);
        membre.setCentraleAchat(null);
    }

}
