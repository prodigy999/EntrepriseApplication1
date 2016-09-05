package store.beans.dao;

import java.util.List;
import javax.ejb.Local;
import store.entity.Utilisateur;

@Local
public interface UtilisateurDAOEJBLocal {
    
    Utilisateur verifierLoginMdp(String log, String mdp)throws RuntimeException;
    
    List<Utilisateur> rechercherLogin(String log)throws RuntimeException;
    
    void ajouterUtilisateur(Utilisateur u)throws RuntimeException;
    
}
