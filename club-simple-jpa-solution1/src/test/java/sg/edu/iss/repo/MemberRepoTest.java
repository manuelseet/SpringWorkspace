package sg.edu.iss.repo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation; //note this is for the TestMethodOrder (don't use ClassOrderer.OrderAnnotations)
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.iss.ClubSimpleJpaSolution1Application;
import sg.edu.iss.domain.Member;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ClubSimpleJpaSolution1Application.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
public class MemberRepoTest {

	@Autowired
	MemberRepository mrepo;
	
	@Test
	@Order(1)
	public void testFindById()
	{
		mrepo.deleteAll();
		Member m1 = new Member(111, "Jessica", "Faul", "Gerards", "JFGRocks", "jessie");
		
		
	}
	
	
}
