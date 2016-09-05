/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.beans.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import store.beans.dao.UtilisateurDAOEJBLocal;
import store.entity.Utilisateur;

/**
 *
 * @author admin
 */
@Stateless
public class UtilisateurServiceEJB implements UtilisateurServiceEJBLocal {
    
    @EJB
    private UtilisateurDAOEJBLocal utilisateurDAOEJBLocal;

    @Override
    public Utilisateur verifierLoginMdp(String log, String mdp) throws RuntimeException {
        
        return utilisateurDAOEJBLocal.verifierLoginMdp(log, mdp);
    }

    @Override
    public void ajouterUtilisateur(Utilisateur u) throws RuntimeException{
        
        List<Utilisateur> listLogExist = utilisateurDAOEJBLocal.rechercherLogin(u.getLogin());
        
        if (listLogExist.size()>0){
            throw new RuntimeException ("Ce login existe déjà");
        }
        
        utilisateurDAOEJBLocal.ajouterUtilisateur(u);
    }

    
}
