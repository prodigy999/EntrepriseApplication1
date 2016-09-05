/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import store.entity.Article;
import store.entity.Commande;
import store.beans.service.ArticleServiceEJBLocal;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutPanier", urlPatterns = {"/ajout_panier"})
public class AjoutPanierServlet extends HttpServlet {
    
    @EJB
    private ArticleServiceEJBLocal articleServiceEJBLocal;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("ajout_panier.jsp").forward(req, resp);
    }

    @Override
    @SuppressWarnings("empty-statement")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //je recupere mes variables
        long idArticle = (Long.parseLong(req.getParameter("idArticle")));
        long quantitePanier = (Long.parseLong(req.getParameter("quantitePanier")));
        
        //
        Article article = articleServiceEJBLocal.rechercheParID(idArticle);
        article.setStock((article.getStock() - quantitePanier));
        articleServiceEJBLocal.modifierArticle(article);
        
        article.setStock(quantitePanier);
        
        long totalPanier = (long)req.getSession().getAttribute("total") + (article.getPrix()* quantitePanier);
        req.getSession().setAttribute("total", totalPanier);
        
        Commande commandeUtilLogger = (Commande)req.getSession().getAttribute("commandeUtilisateur");
        List <Article> panier = commandeUtilLogger.getArticles();
        
        panier.add(article);
        commandeUtilLogger.setArticles(panier);
        
        req.getSession().setAttribute("commandeUtilisateur", commandeUtilLogger);
        
        long nombreArticles = (long)req.getSession().getAttribute("nombreArticles") + quantitePanier;
        req.getSession().setAttribute("nombreArticles", nombreArticles);
        
        resp.sendRedirect("liste_articles");
    }

    

}
