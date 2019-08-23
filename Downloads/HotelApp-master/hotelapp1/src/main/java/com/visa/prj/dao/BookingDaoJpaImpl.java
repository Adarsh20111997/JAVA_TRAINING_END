package com.visa.prj.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		String[] criterias = criteria.split(":");
		String jpql = "select h from Hotel h where h.zip = :zi and h.price > :pr";
		TypedQuery<Hotel> query = em.createQuery(jpql, Hotel.class);
		query.setParameter("zi", criterias[0]);
		BigDecimal b = new BigDecimal(criterias[1]);
		query.setParameter("pr", b);
		 return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql = "select u from User u where u.email= :mail and u.password = :pwd";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("mail", email);
		query.setParameter("pwd", password);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public long createBooking(Booking booking) {
		em.persist(booking);
		return booking.getId();
	}
	@Override
	public User fetchUser(String email) {
		String jpql = "select u from User u where u.email= :mail";
		TypedQuery<User> query = em.createQuery(jpql,User.class);
		query.setParameter("mail", email);
		return query.getSingleResult();
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql = "select b from Booking b where b.user.username = :u";
		TypedQuery<Booking> query = em.createQuery(jpql,Booking.class);
		query.setParameter("u", user.getUsername());
		return query.getResultList();
	}

}
