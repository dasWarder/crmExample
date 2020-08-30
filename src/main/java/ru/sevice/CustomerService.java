package ru.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dao.CustomerDao;
import ru.entity.Customer;
import ru.util.exception.CustomerNotFound;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInt {

    private CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Transactional
    @Override
    public void save(Customer customer) {
        if(customer != null) {
            customerDao.save(customer);
        }
    }

    @Transactional
    @Override
    public Customer get(int id) {
        return customerDao.get(id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        customerDao.delete(id);
    }


}
