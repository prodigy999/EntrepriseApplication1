package jemacarse.controller;

import jemacarse.entity.Course;
import jemacarse.service.CourseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {
    
    
    
    @RequestMapping(value = "/geolocalisation", method = RequestMethod.GET)
    public String geolocalisationSurMap (Model m){
        
        return "geolocalisation";
    }
    
    @RequestMapping(value = "/itineraire", method = RequestMethod.GET)
    public String definirItineraire (Model m){
        
        return "itineraire";
    }
    
    
    
}
