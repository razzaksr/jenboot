package mera.springmvc7.apply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bikes", path="bikes")
public interface BikeCrud extends JpaRepository<Bike, Integer>{
	
}
