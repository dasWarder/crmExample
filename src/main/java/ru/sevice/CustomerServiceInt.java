package ru.sevice;

import ru.entity.Customer;
import java.util.*;

public interface CustomerServiceInt {

    List<Customer> getAll();

    void save(Customer customer);

    Customer get(int id);

    void delete(int id);

}
