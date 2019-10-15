package mera.springmvc6.apply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BikeCrud extends JpaRepository<Bike, Integer>{
	
}
