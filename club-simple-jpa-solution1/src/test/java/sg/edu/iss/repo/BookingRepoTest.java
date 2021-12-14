package sg.edu.iss.repo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation; //note this is for the TestMethodOrder (don't use ClassOrderer.OrderAnnotations)
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

import sg.edu.iss.ClubSimpleJpaSolution1Application;
import sg.edu.iss.domain.Booking;
import sg.edu.iss.domain.Facility;
import sg.edu.iss.domain.Member;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ClubSimpleJpaSolution1Application.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
public class BookingRepoTest {

	@Autowired 
	BookingRepository brepo;
	FacilityRepository frepo;
	MemberRepository mrepo;
	

}
