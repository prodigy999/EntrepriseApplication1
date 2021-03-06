/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import store.entity.Article;
import store.beans.service.ArticleServiceEJBLocal;


/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutStockArticleServlet", urlPatterns = {"/ajout_stock"})
public class AjoutStockArticleServlet extends HttpServlet {
    
    @EJB
    private ArticleServiceEJBLocal articleServiceEJBLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("ajout_stock.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long idArticle = Long.parseLong(req.getParameter("idArticle"));
        Article article = articleServiceEJBLocal.rechercheParID(idArticle);
        
        article.setStock(article.getStock() + (Long.parseLong(req.getParameter("quantiteStock"))));
        
        articleServiceEJBLocal.modifierArticle(article);
        
        resp.sendRedirect("liste_articles");
    }

    
}
