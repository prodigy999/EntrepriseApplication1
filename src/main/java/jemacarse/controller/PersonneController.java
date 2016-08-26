package jemacarse.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import jemacarse.entity.Personne;
import jemacarse.entity.Personne.RolePersonne;
import jemacarse.service.PersonneCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonneController {
    
    @Autowired
    private PersonneCrudService personneCrudService;
    
    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String connexionParLoginGet (Model m, HttpSession session){
        
        session.removeAttribute("connecte");
        
        Personne p = new Personne();
        List<RolePersonne> rolePersonne = new ArrayList<>();
        
        rolePersonne.add(p.getRolePersonne().CHAUFFEUR);
        rolePersonne.add(p.getRolePersonne().CLIENT);
        
        m.addAttribute("inscription", p);
        m.addAttribute("connexion", p);
        m.addAttribute("rolePersonne", rolePersonne);
        
        return "accueil";
    }
    
    @RequestMapping(value = "/accueil", method = RequestMethod.POST)
    public String inscriptionPost (@ModelAttribute ("inscription") Personne p, @ModelAttribute ("connexion") Personne pers, HttpSession session){
        
        if (p.getMotDePasse().equals(p.getMotDePasse2())){
            personneCrudService.save(p);
            return "redirect:/accueil";
        }
        
        try {
        
        Personne personne = new Personne();
        personne = personneCrudService.findOneByLogin (pers.getLogin());
        
        if (personne.getMotDePasse().equals(pers.getMotDePasse())){
            session.setAttribute("connecte", pers);
            return "redirect:/geolocalisation";
        }}
        
        catch (RuntimeException e){
        }
        
        return "redirect:/accueil";
    }
}
