package sg.edu.iss.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import sg.edu.iss.domain.*;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	@Query("select m from Member m where m.firstName = :firstname")
	public List<Facility> FindMemberByFirstName(@Param("firstname") String firstname);
	
}
