package store.beans.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import store.entity.Commande;

@Stateless
public class CommandeDAOEJB implements CommandeDAOEJBLocal {

    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    public void modifierCommande(Commande c) {
        
        em.merge(c);
    }

    @Override
    public List<Commande> listerCommandesTrieParDateEtatFinalise() {
        
        Query query = em.createQuery("SELECT c FROM Commande c WHERE c.etat=:monetat ORDER BY c.dateCommande");
        query.setParameter("monetat", Commande.Etat.FINALISE);
        
        return query.getResultList();
    }

    @Override
    public List<Commande> listerCommandesTrieParDateEtatExpedie() {
        
        Query query = em.createQuery("SELECT c FROM Commande c WHERE c.etat=:monetat ORDER BY c.dateCommande");
        query.setParameter("monetat", Commande.Etat.EXPEDIE);
        
        return query.getResultList();
    }

    @Override
    public Commande rechercheParID(long id) {
        
        return em.find(Commande.class, id);
    }
}
