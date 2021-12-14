package sg.edu.iss.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.domain.Booking;
import sg.edu.iss.domain.Facility;
import sg.edu.iss.domain.Member;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

	//@Query("insert into Bookings (fromDate, toDate, facility, member) Values (:fromDate, :toDate, :facility, :member)")
	//public Booking createBooking(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, 
			//@Param("facility") Facility facility, @Param("Member") Member member);
	
}
