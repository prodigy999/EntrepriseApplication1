/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.beans.service;

import java.util.List;
import javax.ejb.Local;
import store.entity.Article;


@Local
public interface ArticleServiceEJBLocal {
    
    List<Article> listerArticlesTrieParNom();
    
    Article rechercheParID(long id);
    
    void modifierArticle(Article a);
    
    void ajouterArticle(Article a);
    
}
