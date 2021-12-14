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
import sg.edu.iss.domain.Facility;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ClubSimpleJpaSolution1Application.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
public class FacilityRepoTest {

	@Autowired
	FacilityRepository frepo;
	
	@Test
	@Order(5)
	public void testFindFacilitiesByName() {
		frepo.deleteAll(); //clear all entries in the repo for our test
		Facility f1 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 6!");
		Facility f2 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 5");
		Facility f3 = new Facility("Convention Hall", "Large convention hall for conventions and meetings");
		Facility f4 = new Facility("LeafGoldSpa", "Luxurious personal care facility for guests");
		
		List<Facility> flist = new ArrayList<Facility>(); //create an empty list of facilities
		flist.add(f1); flist.add(f2); flist.add(f3); flist.add(f4); //add all the facility objects to our list
		
		frepo.saveAllAndFlush(flist); //save all the new facilities into the repo, and flush to the front
		List<Facility> foundFList = frepo.findFacilitiesByName("Ballroom"); //using the instantiated object frepo, find facilities by name
		
		assertEquals(foundFList.size(), 2);
	}
	
	
	@Test
	@Order(2)
	public void testFindById() {
		frepo.deleteAll(); //clear all entries in the repo for our test
		Facility f1 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 6!");
		Facility f2 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 5");
		Facility f3 = new Facility("Convention Hall", "Large convention hall for conventions and meetings");
		Facility f4 = new Facility("LeafGoldSpa", "Luxurious personal care facility for guests");
		
		List<Facility> flist = new ArrayList<Facility>(); //create an empty list of facilities
		flist.add(f1); flist.add(f2); flist.add(f3); flist.add(f4); //add all the facility objects to our list
		
		frepo.saveAllAndFlush(flist); //save all the new facilities into the repo, and flush to the front
		Facility foundF = frepo.findById(1).get();
		assertEquals(f1, foundF);
	}
	
	@Test
	@Order(1)
	public void testSave() {
		frepo.deleteAll(); //clear all entries in the repo for our test
		Facility f1 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 6!");
		Facility f2 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 5");
		
		frepo.save(f1);
		frepo.save(f2);
		List<Facility> foundFList = frepo.findFacilitiesByName("Ballroom"); //using the instantiated object frepo, find facilities by name

		assertEquals(foundFList.size(), 2);	
	}
	
	@Test
	@Order(3)
	public void testFindAll() {
		frepo.deleteAll(); //clear all entries in the repo for our test
		Facility f1 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 6!");
		Facility f2 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 5");
		Facility f3 = new Facility("Convention Hall", "Large convention hall for conventions and meetings");
		Facility f4 = new Facility("LeafGoldSpa", "Luxurious personal care facility for guests");
		
		List<Facility> flist = new ArrayList<Facility>(); //create an empty list of facilities
		flist.add(f1); flist.add(f2); flist.add(f3); flist.add(f4); //add all the facility objects to our list
		
		frepo.saveAllAndFlush(flist); //save all the new facilities into the repo, and flush to the front
		List<Facility> allFacilities = frepo.findAll();
		
		assertEquals(allFacilities.size(), 4);
	}
	
	@Test
	@Order(4)
	public void testDelete() {
		frepo.deleteAll(); //clear all entries in the repo for our test
		Facility f1 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 6!");
		Facility f2 = new Facility("Ballroom", "Grand ballroom space for celebratory events on Level 5");
		Facility f3 = new Facility("Convention Hall", "Large convention hall for conventions and meetings");
		Facility f4 = new Facility("LeafGoldSpa", "Luxurious personal care facility for guests");
		
		List<Facility> flist = new ArrayList<Facility>(); //create an empty list of facilities
		flist.add(f1); flist.add(f2); flist.add(f3); flist.add(f4); //add all the facility objects to our list
		
		frepo.saveAllAndFlush(flist); //save all the new facilities into the repo, and flush to the front
		frepo.deleteAll();
		List<Facility> retrievedFacilities = frepo.findAll();
		
		assertEquals(retrievedFacilities.size(), 0);
	}
	
}
