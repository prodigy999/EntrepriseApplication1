package store.beans.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import store.entity.Article;


@Stateless
public class ArticleDAOEJB implements ArticleDAOEJBLocal {
    
    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    public List<Article> listerArticlesTrieParNom() {
        
        return em.createQuery("SELECT a FROM Article a ORDER BY a.nom").getResultList();
    }

    @Override
    public Article rechercheParID(long id) {
        
        return em.find(Article.class, id);
    }

    @Override
    public void modifierArticle(Article a) {
        
        em.merge(a);
    }
}
