package store.beans.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import store.beans.dao.ArticleDAOEJBLocal;
import store.entity.Article;

@Stateless
public class ArticleServiceEJB implements ArticleServiceEJBLocal {
    
    @EJB
    private ArticleDAOEJBLocal articleDAOEJBLocal;
    
    @Override
    public List<Article> listerArticlesTrieParNom() {
        
        return articleDAOEJBLocal.listerArticlesTrieParNom();
    }

    @Override
    public Article rechercheParID(long id) {
        
        return articleDAOEJBLocal.rechercheParID(id);
    }

    @Override
    public void modifierArticle(Article a) {
        
        articleDAOEJBLocal.modifierArticle(a);
    }

    @Override
    public void ajouterArticle(Article a) {
        
        articleDAOEJBLocal.modifierArticle(a);
    }

    
}
