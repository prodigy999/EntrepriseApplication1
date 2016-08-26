package jemacarse.service;

import jemacarse.entity.Personne;
import org.springframework.data.repository.CrudRepository;

public interface PersonneCrudService extends CrudRepository<Personne, Long>{
    
    public Personne findOneByLogin (String login);
    
}
