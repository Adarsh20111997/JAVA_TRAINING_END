package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Repository
public class OrderDaoJpaImpl implements OrderDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public void placeOrder(Order o) {
	/*	List<Item> it = o.getItems();
		OrderService os = null;
		boolean flag = true;
		for (Item i : it) {
			Product p = os.getById(i.getProduct().getId());
			if(p.getCount() - i.getQty() < 0 )
			{
				flag = false;
			}
		}
		if(flag==true)
		*/
			em.persist(o);
	}

	@Override
	public List<Order> getOrders(Customer c) {
		if(c==null) {
			String jpql = "from Order";
			TypedQuery<Order> query = em.createQuery(jpql, Order.class);
			return query.getResultList();
		} else {
			String jpql = "from Order o where o.customer = :c";
			TypedQuery<Order> query = em.createQuery(jpql, Order.class);
			query.setParameter("c", c);
			return query.getResultList();
			
		}
	}

}
