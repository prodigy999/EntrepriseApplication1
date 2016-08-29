package jemacarse.controller;

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

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnexion(HttpSession session) {

        session.invalidate();
        
        return "redirect:/accueil";
    }
    
    @RequestMapping(value = "/connexion", method = RequestMethod.POST)
    public String connexionPOST(@ModelAttribute("connexion") Personne p, HttpSession session) {

        Personne personneTrouvee = personneCrudService.findOneByLoginAndMotDePasse(p.getLogin(), p.getMotDePasse());
        
        if (personneTrouvee != null) {
            session.setAttribute("connecte", personneTrouvee);
            return "redirect:/geolocalisation";
        }
        return "redirect:/accueil";
    }

    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String accueil(Model m, HttpSession session) {
        
        Personne p = new Personne();

        m.addAttribute("connexion", p);
        m.addAttribute("inscription", p);
        m.addAttribute("rolePersonne", RolePersonne.values());

        return "accueil";
    }

    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public String inscriptionPost(@ModelAttribute("inscription") Personne p) {

        if (p.getMotDePasse().equals(p.getMotDePasse2())){
            personneCrudService.save(p);}
            
            return "redirect:/accueil";
    }

    @RequestMapping(value = "/historique", method = RequestMethod.GET)
    public String afficheHistorique(Model m, HttpSession session) {

        return "historique";
    }
}
