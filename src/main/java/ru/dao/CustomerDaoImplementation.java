package ru.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.entity.Customer;

import java.util.List;

@Repository
public class CustomerDaoImplementation  implements CustomerDao{

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImplementation(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();

        Query customersQuery = session.createQuery("FROM Customer ORDER BY first_name", Customer.class);

        return customersQuery.getResultList();
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public Customer get(int id) {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        return customer;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("DELETE FROM Customer c WHERE c.id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();
    }


}
