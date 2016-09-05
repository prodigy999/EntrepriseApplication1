package store.beans.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import store.entity.Utilisateur;

@Stateless
public class UtilisateurDAOEJB implements UtilisateurDAOEJBLocal {
    
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    public Utilisateur verifierLoginMdp(String log, String mdp) throws RuntimeException {
        
        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:monlog AND u.motDePasse=:monmdp");
        query.setParameter("monlog", log);
        query.setParameter("monmdp", mdp);
        
        return (Utilisateur) query.getSingleResult();
    }

    @Override
    public List<Utilisateur> rechercherLogin(String log) throws RuntimeException {
        
        Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:monlog ");
        query.setParameter("monlog", log);
        
        return query.getResultList();
    }

    @Override
    public void ajouterUtilisateur(Utilisateur u) throws RuntimeException {
        
        em.persist(u);
    }
}
