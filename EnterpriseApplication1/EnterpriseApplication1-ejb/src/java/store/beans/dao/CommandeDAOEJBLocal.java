/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.beans.dao;

import java.util.List;
import javax.ejb.Local;
import store.entity.Commande;

/**
 *
 * @author admin
 */
@Local
public interface CommandeDAOEJBLocal {
    
    void modifierCommande(Commande c);
    
    List<Commande> listerCommandesTrieParDateEtatFinalise();
    
    List<Commande> listerCommandesTrieParDateEtatExpedie();
    
    Commande rechercheParID(long id);
    
    
}
