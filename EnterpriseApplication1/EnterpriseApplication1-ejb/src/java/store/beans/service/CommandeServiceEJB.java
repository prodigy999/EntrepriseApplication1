/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.beans.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import store.beans.dao.CommandeDAOEJBLocal;
import store.entity.Commande;

/**
 *
 * @author admin
 */
@Stateless
public class CommandeServiceEJB implements CommandeServiceEJBLocal {
    
    @EJB
    private CommandeDAOEJBLocal commandeDAOEJBLocal;

    @Override
    public void ajouterCommande(Commande c) {
        
        commandeDAOEJBLocal.modifierCommande(c);
    }

    @Override
    public void modifierCommande(Commande c) {
        
        commandeDAOEJBLocal.modifierCommande(c);
    }

    @Override
    public List<Commande> listerCommandesTrieParDateEtatFinalise() {
        
        return commandeDAOEJBLocal.listerCommandesTrieParDateEtatFinalise();
    }

    @Override
    public List<Commande> listerCommandesTrieParDateEtatExpedie() {
        
        return commandeDAOEJBLocal.listerCommandesTrieParDateEtatExpedie();
    }

    @Override
    public Commande rechercheParID(long id) {
        
        return commandeDAOEJBLocal.rechercheParID(id);
    }
}
