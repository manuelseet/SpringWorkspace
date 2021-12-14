package sg.edu.iss.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.domain.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query("Select f from Facility f where f.name = :name")
	List<Facility> findFacilitiesByName(@Param("name") String name);

	
}
