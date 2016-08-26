package jemacarse.service;

import jemacarse.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseCrudService extends CrudRepository<Course, Long>{
    
}
