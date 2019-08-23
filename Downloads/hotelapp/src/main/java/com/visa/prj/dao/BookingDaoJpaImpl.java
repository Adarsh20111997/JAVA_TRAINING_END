package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		 return null;
	}

	@Override
	public Hotel findHotelById(long id) {
		return null;
	}

	@Override
	public User getUser(String email, String password) {
		return null;
	}

	@Override
	public long createBooking(Booking booking) {
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		return null;
	}

}
