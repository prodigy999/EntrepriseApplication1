package store.beans.service;

import javax.ejb.Local;
import store.entity.Utilisateur;

@Local
public interface UtilisateurServiceEJBLocal {
    
    Utilisateur verifierLoginMdp(String log, String mdp);
    
    void ajouterUtilisateur (Utilisateur u);
    
}
