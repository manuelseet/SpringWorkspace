package sg.edu.iss.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer bookingId;
	public Facility facility;
	public Member member;
	public Date fromDate;
	public Date toDate;
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
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Booking(Integer bookingId, Facility facility, Member member, Date fromDate, Date toDate,
			String description) {
		super();
		this.bookingId = bookingId;
		this.facility = facility;
		this.member = member;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", facility=" + facility + ", member=" + member + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", description=" + description + "]";
	} 
	
	
	

}
