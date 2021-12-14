package sg.edu.iss.domain;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "Bookings")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer bookingId;
	@OneToOne
	public Facility facility;
	@OneToOne
	public Member member;
	@FutureOrPresent
	@DateTimeFormat (pattern="dd-MM-yyyy")
	public LocalDate fromDate;
	@FutureOrPresent
	@DateTimeFormat (pattern="dd-MM-yyyy")
	public LocalDate toDate;
	public String description;

	
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", facility=" + facility + ", member=" + member + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", description=" + description + "]";
	}
	public Booking(Integer bookingId, @NotEmpty Facility facility, @NotEmpty Member member, @FutureOrPresent LocalDate fromDate,
			@FutureOrPresent LocalDate toDate, String description) {
		super();
		this.bookingId = bookingId;
		this.facility = facility;
		this.member = member;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	} 
	
	
	

}
