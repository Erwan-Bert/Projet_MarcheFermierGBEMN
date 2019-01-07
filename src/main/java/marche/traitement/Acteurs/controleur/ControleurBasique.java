package marche.traitement.Acteurs.controleur;

import marche.traitement.Marche.Offre;

public class ControleurBasique extends Controleur{

    @Override
    public boolean validerOffre(Offre o) {
        return (o.getPrix() < 1000000); //validation purement arbitraire
    }

    @Override
    public String getNom(){
        return "AMF";
    }
}
