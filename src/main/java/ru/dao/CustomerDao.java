package ru.dao;

import ru.entity.Customer;
import java.util.*;

public interface CustomerDao {

    List<Customer> getAll();

    void save(Customer customer);

    Customer get(int id);

    void delete(int id);
}
